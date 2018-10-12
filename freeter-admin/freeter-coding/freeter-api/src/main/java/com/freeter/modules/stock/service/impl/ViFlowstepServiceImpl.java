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

import com.freeter.modules.stock.dao.ViFlowstepDao;
import com.freeter.modules.stock.entity.ViFlowstepEntity;
import com.freeter.modules.stock.service.ViFlowstepService;
import com.freeter.modules.stock.entity.view.ViFlowstepView;


@Service("viFlowstepService")
public class ViFlowstepServiceImpl extends ServiceImpl<ViFlowstepDao, ViFlowstepEntity> implements ViFlowstepService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ViFlowstepEntity> page = this.selectPage(
                new Query<ViFlowstepEntity>(params).getPage(),
                new EntityWrapper<ViFlowstepEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ViFlowstepEntity> wrapper) {
		  Page<ViFlowstepView> page =new Query<ViFlowstepView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	public List<ViFlowstepView> selectListView(Wrapper<ViFlowstepEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ViFlowstepView selectView(Wrapper<ViFlowstepEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
