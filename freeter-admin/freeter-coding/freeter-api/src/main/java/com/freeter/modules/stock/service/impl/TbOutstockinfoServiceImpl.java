package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.HttpContextUtils;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.dao.TbCarinfoDao;
import com.freeter.modules.stock.dao.TbInstockinfoDao;
import com.freeter.modules.stock.dao.TbInstockinfoDetailDao;
import com.freeter.modules.stock.dao.TbOutstockinfoDao;
import com.freeter.modules.stock.dao.TbOutstockinfodetailDao;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.model.TbInstockinfodetailModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfoModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfodetailModel;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.modules.stock.service.TbOutstockinfoService;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.Constant;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;
import com.freeter.modules.stock.entity.view.ViCarstatusinfoView;


@Service("tbOutstockinfoService")
public class TbOutstockinfoServiceImpl extends ServiceImpl<TbOutstockinfoDao, TbOutstockinfoEntity> implements TbOutstockinfoService {

	@Autowired
	private TbOutstockinfoDao tbOutstockinfoDao;
	
	@Autowired
	private TbOutstockinfodetailDao tbOutstockinfoDetailDao;
	
	@Autowired
	private TbCarinfoDao tbCarinfoDao;
	
	@Autowired
	private TbCarcirculationService tbCarcirculationService;
	
	@Autowired
	private SysUserService sysUserService;
	
	@Override
	public PageUtils selectoutstockinfoList(Page<TbOutstockinfoView> page, Map<String, String> map) {
		page.setRecords(tbOutstockinfoDao.selectTbOutstockinfoList(page,map));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}

	@Override
	public List<TbOutstockinfoView> selectoutstockinfoListById(Map<String, String> map) {
		
		return tbOutstockinfoDao.selectoutstockinfoListById(map);
	}

	@Transactional
	public R saveTbOutstockinfo(TbOutstockinfoModel outstockinfoModel) {
		List<TbOutstockinfodetailModel> outstockDetail = outstockinfoModel.getData();
		List<Map> list = tbOutstockinfoDao.selectTimeByVinnumber(outstockDetail);
		for (Map map : list) {
			if(map.get("OutStockTime")!=null&& map.get("ReturnStockTime")!=null) {
			Date outtime = outstockinfoModel.getOutstocktime();
			Date returntime = outstockinfoModel.getReturnstocktime();
			Date outstocktime = (Date) map.get("OutStockTime");
			Date returnstocktime = (Date) map.get("ReturnStockTime");
			if(!((returntime.getTime()<outstocktime.getTime())||(outtime.getTime()>returnstocktime.getTime()))) {
				return R.error("时间错误").put("car", map.get("VinNumber"));	
			}
			}
		}
		if ((outstockDetail==null)||(outstockDetail.size()==0)) {
			return R.error("车辆数不能为0");
		}
		tbOutstockinfoDao.saveOutstockinfo(outstockinfoModel);
		for (TbOutstockinfodetailModel tbOutstockinfodetailModel : outstockDetail) {
			tbOutstockinfodetailModel.setOutstockid(outstockinfoModel.getOutstockid());	
			tbOutstockinfoDetailDao.saveOutstockinfoDetail(tbOutstockinfodetailModel);	
		}
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		List<TbCarcirculationEntity> arraylist = new ArrayList<>();
		for(int i=0; i<outstockDetail.size(); i++){
			TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
			tbCarcirculationEntity.setVinnumber(outstockDetail.get(i).getVinnumber());
			tbCarcirculationEntity.setCircutype(8);
			tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
			tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
			arraylist.add(tbCarcirculationEntity);
		}
		tbCarcirculationService.insertBatch(arraylist, arraylist.size());
		
		return R.ok();
	}
	
	@Transactional
	public R auditOutstockinfo(Map<String, String> map) {
		
		Integer auditOutstockinfo = tbOutstockinfoDao.auditOutstockinfo(map);
		if(map.get("auditState").equals("2")) {
			List<Map> list=tbOutstockinfoDao.selectVinnumberByOutstockId(map);
			HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
			String userId = request.getAttribute("userId").toString();
			List<TbCarcirculationEntity> arraylist = new ArrayList<>();
			for(int i=0; i<list.size(); i++){
				TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
				tbCarcirculationEntity.setVinnumber((String)list.get(i).get("VinNumber"));
				tbCarcirculationEntity.setCircutype(20);
				tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
				tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
				arraylist.add(tbCarcirculationEntity);
			}
			tbCarcirculationService.insertBatch(arraylist, arraylist.size());
			return R.ok();
		}
		if(map.get("auditState").equals("1")) {
		List<Map> list=tbOutstockinfoDao.selectVinnumberByOutstockId(map);
		//tbOutstockinfoDao.updateCarStatusByOutstock(map);
		//tbCarinfoDao.outstockupdateCarStatusByVinnumber(list);
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		List<TbCarcirculationEntity> arraylist = new ArrayList<>();
		for(int i=0; i<list.size(); i++){
			TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
			tbCarcirculationEntity.setVinnumber((String)list.get(i).get("VinNumber"));
			tbCarcirculationEntity.setCircutype(9);
			tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
			tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
			arraylist.add(tbCarcirculationEntity);
		}
		tbCarcirculationService.insertBatch(arraylist, arraylist.size());
		}
		
		return R.ok();
	}
	
	@Override
	public List<TbOutstockinfoView> selectoutstockinfoList(Map<String, String> map) {
		
		return tbOutstockinfoDao.selectTbOutstockinfoListExport(map);
	}
	
	
	
	@DataFilter(subDept = true, user = false)
	public PageUtils selectoutstockinfoList(Map<String, Object> params, Wrapper<TbOutstockinfoEntity> wrapper) {
		Page<TbOutstockinfoView> page = new Query<TbOutstockinfoView>(params).getPage();
		page.setRecords(baseMapper.selectTbOutstockinfoList(page,
				wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
 	}
	
	@Override
    @DataFilter(subDept = true, user = false)
    public List<TbOutstockinfoView> selectoutstockList(Map<String,String> map,Wrapper<TbOutstockinfoEntity> wrapper){
    	List<TbOutstockinfoView> list = new ArrayList<>();
    	list = baseMapper.selectTbOutstockinfoList(wrapper.addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
    	return list; 
    }

}
