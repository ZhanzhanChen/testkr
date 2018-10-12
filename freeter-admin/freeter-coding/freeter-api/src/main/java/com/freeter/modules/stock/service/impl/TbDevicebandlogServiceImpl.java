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
import com.freeter.modules.stock.dao.TbDevicebandlogDao;
import com.freeter.modules.stock.entity.TbDevicebandlogEntity;
import com.freeter.modules.stock.service.TbDevicebandlogService;
import com.freeter.modules.stock.entity.view.TbDevicebandlogView;


@Service("tbDevicebandlogService")
public class TbDevicebandlogServiceImpl extends ServiceImpl<TbDevicebandlogDao, TbDevicebandlogEntity> implements TbDevicebandlogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbDevicebandlogEntity> page = this.selectPage(
                new Query<TbDevicebandlogEntity>(params).getPage(),
                new EntityWrapper<TbDevicebandlogEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbDevicebandlogEntity> wrapper) {
		  Page<TbDevicebandlogView> page =new Query<TbDevicebandlogView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	public List<TbDevicebandlogView> selectListView(Wrapper<TbDevicebandlogEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TbDevicebandlogView selectView(Wrapper<TbDevicebandlogEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
