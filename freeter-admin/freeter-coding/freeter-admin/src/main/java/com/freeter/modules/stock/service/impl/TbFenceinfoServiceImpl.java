package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.stock.dao.TbFenceinfoDao;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.service.TbFenceinfoService;


@Service("tbFenceinfoService")
public class TbFenceinfoServiceImpl extends ServiceImpl<TbFenceinfoDao, TbFenceinfoEntity> implements TbFenceinfoService {


	@Autowired
	private TbFenceinfoDao tbFenceinfoDao;
	
	 
	public TbFenceinfoEntity selectTbFenceinfoById(String id) {
		 
		return tbFenceinfoDao.selectTbFenceinfoById(id);
	}

	
	public int saveTbFenceinfo(TbFenceinfoEntity tbFenceinfo) {
		
		
		return tbFenceinfoDao.saveTbFenceinfo(tbFenceinfo);
	}


	@Override
	public String callFenceinfo(Map<String, String> map) {
		
		tbFenceinfoDao.callFenceinfo(map);
		return map.get("result");
		
	}


	
	public PageUtils selectFenceinfoList(Page<TbFenceinfoView> page, Map<String, String> map) {
		
		page.setRecords(tbFenceinfoDao.selectFenceinfoList(page,map));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}


	
	
	

	


	

}
