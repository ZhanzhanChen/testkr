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

import com.freeter.modules.stock.dao.TbCarfencestatusDao;
import com.freeter.modules.stock.entity.TbCarfencestatusEntity;
import com.freeter.modules.stock.service.TbCarfencestatusService;
import com.freeter.modules.stock.entity.view.TbCarfencestatusView;


@Service("tbCarfencestatusService")
public class TbCarfencestatusServiceImpl extends ServiceImpl<TbCarfencestatusDao, TbCarfencestatusEntity> implements TbCarfencestatusService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbCarfencestatusEntity> page = this.selectPage(
                new Query<TbCarfencestatusEntity>(params).getPage(),
                new EntityWrapper<TbCarfencestatusEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbCarfencestatusEntity> wrapper) {
		  Page<TbCarfencestatusView> page =new Query<TbCarfencestatusView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	public List<TbCarfencestatusView> selectListView(Wrapper<TbCarfencestatusEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TbCarfencestatusView selectView(Wrapper<TbCarfencestatusEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
