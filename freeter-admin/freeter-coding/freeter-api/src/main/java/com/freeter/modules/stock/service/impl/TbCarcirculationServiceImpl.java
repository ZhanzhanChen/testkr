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
import com.freeter.modules.stock.dao.TbCarcirculationDao;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.service.TbCarcirculationService;
import com.freeter.modules.stock.entity.view.TbCarcirculationView;


@Service("tbCarcirculationService")
public class TbCarcirculationServiceImpl extends ServiceImpl<TbCarcirculationDao, TbCarcirculationEntity> implements TbCarcirculationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbCarcirculationEntity> page = this.selectPage(
                new Query<TbCarcirculationEntity>(params).getPage(),
                new EntityWrapper<TbCarcirculationEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbCarcirculationEntity> wrapper) {
		  Page<TbCarcirculationView> page =new Query<TbCarcirculationView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	public List<TbCarcirculationView> selectListView(Wrapper<TbCarcirculationEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TbCarcirculationView selectView(Wrapper<TbCarcirculationEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
