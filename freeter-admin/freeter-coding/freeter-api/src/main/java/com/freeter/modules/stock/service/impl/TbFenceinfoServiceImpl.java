package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.dao.TbFenceinfoDao;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.view.PolygonView;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.utils.Constant;
import com.freeter.utils.GetDistanceByLatLng;
import com.freeter.utils.PolygonUtil;


@Service("tbFenceinfoService")
public class TbFenceinfoServiceImpl extends ServiceImpl<TbFenceinfoDao, TbFenceinfoEntity> implements TbFenceinfoService {


	@Autowired
	private TbFenceinfoDao tbFenceinfoDao;
	
	 
	public TbFenceinfoView selectTbFenceinfoById(String id) {
		 
		return tbFenceinfoDao.selectTbFenceinfoById(id);
	}

	
	public int saveTbFenceinfo(TbFenceinfoEntity tbFenceinfo) {
		
		
		return tbFenceinfoDao.saveTbFenceinfo(tbFenceinfo);
	}
	

	@Override
	public String callFenceinfo(TbFenceinfoEntity tbFenceinfoEntity) {
		
		
		return  tbFenceinfoDao.callFenceinfo(tbFenceinfoEntity);
		
	}

	
	public PageUtils selectFenceinfoList(Page<TbFenceinfoView> page, Map<String, String> map) {
		
		page.setSearchCount(true);
		page.setRecords(tbFenceinfoDao.selectDealerFenceinfoList(page,map));
    	PageUtils pageUtil = new PageUtils(page);
    	
    	return pageUtil;
	}


	@Override
	public R disableTbFenceinfo(Map<String, String> map) {
		map.put("isEnable","1");
		tbFenceinfoDao.disableTbFenceinfo(map);
		return R.ok();
	}


	@Override
	public Map<String,String> getDealerIdByUserId(Long userId) {
		
		return tbFenceinfoDao.getDealerIdByUserId(userId);
	}
	
	@Override
	public Map<String,Object> getDealerLevelByUserId(Long userId) {
		
		return tbFenceinfoDao.getDealerLevelByUserId(userId);
	}


	@Override
	public R ableTbFenceinfo(Map<String, String> map) {
		map.put("isEnable","0");
		if(tbFenceinfoDao.carfence(map)!= 0){
				return R.error("禁用失败，围栏里有车辆。");
			}
		tbFenceinfoDao.disableTbFenceinfo(map);
		return R.ok();
	}


	@Override
	public Map<String, Object> getDealerById(String dealerId) {
		
		return tbFenceinfoDao.getDealerById(dealerId);
	}


	@Override
	public Map<String, Long> getDeptIdByUserId(Long userId) {
		
		return tbFenceinfoDao.getDeptIdByUserId(userId);
	}


	
	@DataFilter(subDept = true, user = false)
	public PageUtils selectFenceinfoList(Map<String, Object> params, Wrapper<TbFenceinfoEntity> wrapper) {
		Page<TbFenceinfoView> page = new Query<TbFenceinfoView>(params).getPage();
		page.setRecords(baseMapper.selectFenceinfoList(page,
				wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
 	}


	public List<TbFenceinfoEntity> selectFenceinfoByDistance(String dealerid,PolygonView polygonView) {
		Map<String, Object> dealerById = tbFenceinfoDao.getDealerById(dealerid);
		String ownDealerId=(String) dealerById.get("RootDealerId");
		Map<String,Object> map = new HashMap<>();
		map.put("ownDealerId", ownDealerId);
		List<TbFenceinfoEntity> fenceinfolist =new ArrayList<>();
		List<TbFenceinfoEntity> list = tbFenceinfoDao.selectByownDealerId(map);
		for (TbFenceinfoEntity tbFenceinfoEntity : list) {
			String fencepolygon = tbFenceinfoEntity.getFencepolygon();
			List<PolygonView> polygonConvert = PolygonUtil.polygonConvert(fencepolygon);
			for (PolygonView polygon : polygonConvert) {
				double distance = GetDistanceByLatLng.getDistance(polygonView, polygon);
				if (distance<2000) {
					tbFenceinfoEntity.setFencepoints(polygonConvert);
					fenceinfolist.add(tbFenceinfoEntity);	
					break;
				}
			}
		}
		return fenceinfolist;
		
	}
	

	

}
