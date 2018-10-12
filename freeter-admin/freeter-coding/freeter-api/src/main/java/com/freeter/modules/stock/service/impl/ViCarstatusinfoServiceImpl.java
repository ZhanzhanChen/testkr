package com.freeter.modules.stock.service.impl;

import org.apache.ibatis.annotations.Param;
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
import com.freeter.modules.stock.dao.ViCarstatusinfoDao;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.service.TbFenceinfoService;
import com.freeter.modules.stock.service.ViCarstatusinfoService;
import com.freeter.utils.Constant;
import com.freeter.modules.stock.entity.view.ViCarstatusinfoView;


@Service("viCarstatusinfoService")
public class ViCarstatusinfoServiceImpl extends ServiceImpl<ViCarstatusinfoDao, ViCarstatusinfoEntity> implements ViCarstatusinfoService {
    
	@Autowired
	private TbFenceinfoService tbFenceinfoService;
	
    @Override
    @DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ViCarstatusinfoEntity> wrapper) {
		Page<ViCarstatusinfoView> page = new Query<ViCarstatusinfoView>(params).getPage();
		page.setRecords(baseMapper.selectListView(page,
				wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
 	}
    
    @Override
    @DataFilter(subDept = true, user = false)
	public PageUtils queryPageDealer(Map<String, Object> params, Wrapper<ViCarstatusinfoEntity> wrapper) {
		Page<ViCarstatusinfoView> page = new Query<ViCarstatusinfoView>(params).getPage();
		page.setRecords(baseMapper.selectListView(page, 
				wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
		PageUtils pageUtil = new PageUtils(page);
		return pageUtil;
 	}
    
    @Override
    @DataFilter(subDept = true, user = false)
    public List<ViCarstatusinfoEntity> querylist(Map<String, String> params,Wrapper<ViCarstatusinfoEntity> wrapper){
    	List<ViCarstatusinfoEntity> list = new ArrayList<>();
    	list = baseMapper.selectList(wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER)));
    	return list; 
    }
    
    @Override
    public ViCarstatusinfoEntity selectOneByVinnumber(@Param("ew") Wrapper<ViCarstatusinfoEntity> wrapper){
    	ViCarstatusinfoEntity entity = baseMapper.selectOneByVinnumber(wrapper);
    	return entity;
    }
    
    @Override
    @DataFilter(subDept = true, user = false)
    public List<TbFenceinfoEntity> queryFenceinfoList(Map<String, Object> params, Wrapper<TbFenceinfoEntity> wrapper){
    	List<TbFenceinfoEntity> list = baseMapper.queryFenceinfoList(wrapper);
    	return list;
    }

}
