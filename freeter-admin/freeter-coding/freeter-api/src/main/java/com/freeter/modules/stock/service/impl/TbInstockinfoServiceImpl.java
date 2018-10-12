package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
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
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;
import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.model.TbInstockinfodetailModel;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.modules.stock.service.TbInstockinfoService;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.Constant;


@Service("tbInstockinfoService")
public class TbInstockinfoServiceImpl extends ServiceImpl<TbInstockinfoDao,TbInstockinfoEntity> implements TbInstockinfoService {


	@Autowired
	private TbInstockinfoDao tbInstockinfoDao;
	
	@Autowired
	private TbInstockinfoDetailDao tbInstockinfoDetailDao;
	
	@Autowired
	private TbCarinfoDao tbCarinfoDao;
	
	@Autowired
	private TbCarcirculationService tbCarcirculationService;
	
	@Autowired
	private SysUserService sysUserService;

	@Override
	public PageUtils selectinstockinfoList(Page<TbInstockinfoView> page, Map<String, String> map) {
		
		page.setRecords(tbInstockinfoDao.selectTbInstockinfoList(page,map));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}

	@Override
	public List<TbInstockinfoView> selectinstockinfoListById(Map<String, String> map) {
		
		return tbInstockinfoDao.selectinstockinfoListById(map);
	}

	@Transactional
	public R saveTbInstockinfo(TbInstockinfoModel instockinfoModel) {
		List<TbInstockinfodetailModel> list = instockinfoModel.getData();
		if ((list==null)||(list.size()==0)) {
			return R.error("车辆数不能为0");
		}
		tbInstockinfoDao.saveInstockinfo(instockinfoModel);
		for (TbInstockinfodetailModel tbInstockinfodetailModel : list) {
			tbInstockinfodetailModel.setInstockid(instockinfoModel.getInstockid());	
			tbInstockinfoDetailDao.saveInstockinfoDetail(tbInstockinfodetailModel);	
		}
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		List<TbCarcirculationEntity> arraylist = new ArrayList<>();
		for(int i=0; i<list.size(); i++){
			TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
			tbCarcirculationEntity.setVinnumber(list.get(i).getVinnumber());
			tbCarcirculationEntity.setCircutype(6);
			tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
			tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
			arraylist.add(tbCarcirculationEntity);
		}
		tbCarcirculationService.insertBatch(arraylist, arraylist.size());
		
		
		return R.ok();
	}

	@Override
	public List<TbInstockinfoView> selectinstockinfoList(Map<String, String> map) {
		
		return tbInstockinfoDao.selectTbInstockinfoList(map);
	}

	@Transactional
	public R auditInstockinfo(Map<String, String> map) {
		Integer auditInstockinfo = tbInstockinfoDao.auditInstockinfo(map);
		if(map.get("auditState").equals("2")) {
			List<Map> list=tbInstockinfoDao.selectVinnumberByInstockId(map);
			HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
			String userId = request.getAttribute("userId").toString();
			List<TbCarcirculationEntity> arraylist = new ArrayList<>();
			for(int i=0; i<list.size(); i++){
				TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
				tbCarcirculationEntity.setVinnumber((String)list.get(i).get("VinNumber"));
				tbCarcirculationEntity.setCircutype(19);
				tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
				tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
				arraylist.add(tbCarcirculationEntity);
			}
			tbCarcirculationService.insertBatch(arraylist, arraylist.size());
			return R.ok();
		}
		if(map.get("auditState").equals("1")) {
		List<Map> list=tbInstockinfoDao.selectVinnumberByInstockId(map);
		tbInstockinfoDao.updateCarStatusByInstock(map);
		
		tbCarinfoDao.updateCarStatusByVinnumber(list);
		
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		String userId = request.getAttribute("userId").toString();
		List<TbCarcirculationEntity> arraylist = new ArrayList<>();
		for(int i=0; i<list.size(); i++){
			TbCarcirculationEntity tbCarcirculationEntity= new TbCarcirculationEntity<>();
			tbCarcirculationEntity.setVinnumber((String)list.get(i).get("VinNumber"));
			tbCarcirculationEntity.setCircutype(7);
			tbCarcirculationEntity.setOperateid(Long.valueOf(userId));
			tbCarcirculationEntity.setOperator(sysUserService.selectById(userId).getUsername());
			arraylist.add(tbCarcirculationEntity);
		}
		tbCarcirculationService.insertBatch(arraylist, arraylist.size());
		}
		return R.ok();
	}
	
	 
	

	@DataFilter(subDept = true, user = false)
	public PageUtils selectinstockinfoList(Map<String, Object> params, Wrapper<TbInstockinfoEntity> wrapper) {
		Page<TbInstockinfoView> page = new Query<TbInstockinfoView>(params).getPage();
		page.setRecords(baseMapper.selectTbInstockinfoList(page,
				wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
 	}
	
	
	@Override
    @DataFilter(subDept = true, user = false)
    public List<TbInstockinfoView> selectinstockList(Map<String,String> map,Wrapper<TbInstockinfoEntity> wrapper){
    	List<TbInstockinfoView> list = new ArrayList<>();
    	list = baseMapper.selectTbInstockinfoList(wrapper.addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
    	return list; 
    }
	


	

}

