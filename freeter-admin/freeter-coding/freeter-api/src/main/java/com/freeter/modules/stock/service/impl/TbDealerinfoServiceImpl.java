package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.annotation.DataFilter;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.modules.stock.dao.TbDealerinfoDao;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.service.TbDealerinfoService;
import com.freeter.utils.Constant;
import com.freeter.modules.stock.entity.view.TbDealerinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;


@Service("tbDealerinfoService")
public class TbDealerinfoServiceImpl extends ServiceImpl<TbDealerinfoDao, TbDealerinfoEntity> implements TbDealerinfoService {

	@Autowired
	private TbDealerinfoDao tbDealerinfoDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TbDealerinfoEntity> page = this.selectPage(
                new Query<TbDealerinfoEntity>(params).getPage(),
                new EntityWrapper<TbDealerinfoEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbDealerinfoEntity> wrapper) {
		  Page<TbDealerinfoView> page =new Query<TbDealerinfoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;

 	}
	
	@Override
	public List<TbDealerinfoView> selectListView(Wrapper<TbDealerinfoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TbDealerinfoView selectView(Wrapper<TbDealerinfoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


	public List<TbDealerinfoEntity> selectDealerList(Map<String, String> params) {
		
		return tbDealerinfoDao.selectDealer(params);
	}

	
	@Override
    @DataFilter(subDept = true, user = false)
	public List<TbDealerinfoEntity> selectDealerList(Map<String, String> map, Wrapper<TbDealerinfoEntity> wrapper) {
		List<TbDealerinfoEntity> list = new ArrayList<>();
		list=baseMapper.selectDealer(wrapper.addFilterIfNeed(null!=map.get(Constant.SQL_FILTER), (String)map.get(Constant.SQL_FILTER)));
		return list;
	}
}
