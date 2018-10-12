package com.freeter.modules.stock.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.ViDevicebandlogDao;
import com.freeter.modules.stock.entity.ViDevicebandlogEntity;
import com.freeter.modules.stock.service.ViDevicebandlogService;
import com.freeter.modules.stock.entity.view.ViDevicebandlogView;


@Service("viDevicebandlogService")
public class ViDevicebandlogServiceImpl extends ServiceImpl<ViDevicebandlogDao, ViDevicebandlogEntity> implements ViDevicebandlogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ViDevicebandlogEntity> page = this.selectPage(
                new Query<ViDevicebandlogEntity>(params).getPage(),
                new EntityWrapper<ViDevicebandlogEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ViDevicebandlogEntity> wrapper) {
		  Page<ViDevicebandlogView> page =new Query<ViDevicebandlogView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	public List<ViDevicebandlogView> selectListView(Wrapper<ViDevicebandlogEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ViDevicebandlogView selectView(Wrapper<ViDevicebandlogEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
