package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.TbAlarminfoDao;
import com.freeter.modules.stock.entity.TbAlarminfoEntity;
import com.freeter.modules.stock.service.TbAlarminfoService;
import com.freeter.modules.stock.service.ViFenceinalarmService;
import com.freeter.utils.Constant;
import com.freeter.modules.stock.entity.view.TbAlarminfoView;


@Service("tbAlarminfoService")
public class TbAlarminfoServiceImpl extends ServiceImpl<TbAlarminfoDao, TbAlarminfoEntity> implements TbAlarminfoService {

	@Autowired
	private ViFenceinalarmService viFenceinalarmService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbAlarminfoEntity> page = this.selectPage(
                new Query<TbAlarminfoEntity>(params).getPage(),
                new EntityWrapper<TbAlarminfoEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbAlarminfoEntity> wrapper) {
		  Page<TbAlarminfoView> page =new Query<TbAlarminfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}

    @Override
	public List<TbAlarminfoView> selectListView(Wrapper<TbAlarminfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TbAlarminfoView selectView(Wrapper<TbAlarminfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}
	
	@Override
	public Boolean updateAllIsread(Map<String, List<Object>> map){
		EntityWrapper<TbAlarminfoEntity> ew = new EntityWrapper<TbAlarminfoEntity>();
		ew.in("id", map.get("id"));	
		ew.eq("alarmtype", 1);
		ew.eq("deleted", 0);
		ew.eq("isread", 0);
		TbAlarminfoEntity alar = new TbAlarminfoEntity();
		alar.setIsread(1);
	 	int value = baseMapper.update(alar,ew);
	 	return value>0?true:false;
	}

}
