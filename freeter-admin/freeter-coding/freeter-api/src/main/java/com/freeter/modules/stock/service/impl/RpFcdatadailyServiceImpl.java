package com.freeter.modules.stock.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.RpFcdatadailyDao;
import com.freeter.modules.stock.entity.RpFcdatadailyEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.view.RpFcdatadailyView;
import com.freeter.modules.stock.service.RpFcdatadailyService;
import com.freeter.utils.Constant;


@Service("rpFcdatadailyService")
public class RpFcdatadailyServiceImpl extends ServiceImpl<RpFcdatadailyDao, RpFcdatadailyEntity> implements RpFcdatadailyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RpFcdatadailyEntity> page = this.selectPage(
                new Query<RpFcdatadailyEntity>(params).getPage(),
                new EntityWrapper<RpFcdatadailyEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    @DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RpFcdatadailyEntity> wrapper) {
		  Page<RpFcdatadailyView> page =new Query<RpFcdatadailyView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,
	        		wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER))));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
    
    @Override
    @DataFilter(subDept = true, user = false)
    public List<RpFcdatadailyEntity> querylist(Map<String, Object> params,Wrapper<RpFcdatadailyEntity> wrapper){
    	List<RpFcdatadailyEntity> list = new ArrayList<>();
    	list = baseMapper.selectList(wrapper.addFilterIfNeed(null!=params.get(Constant.SQL_FILTER), (String)params.get(Constant.SQL_FILTER)));
    	return list; 
    }

}
