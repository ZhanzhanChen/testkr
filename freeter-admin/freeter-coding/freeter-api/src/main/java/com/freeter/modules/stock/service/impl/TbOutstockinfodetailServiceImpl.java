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
import com.freeter.modules.stock.dao.TbOutstockinfodetailDao;
import com.freeter.modules.stock.entity.TbOutstockinfodetailEntity;
import com.freeter.modules.stock.service.TbOutstockinfodetailService;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;


@Service("tbOutstockinfodetailService")
public class TbOutstockinfodetailServiceImpl extends ServiceImpl<TbOutstockinfodetailDao, TbOutstockinfodetailEntity> implements TbOutstockinfodetailService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		
		return null;
	}

	@Override
	public List<TbOutstockinfodetailView> selectListView(Wrapper<TbOutstockinfodetailEntity> wrapper) {
		
		return null;
	}

	@Override
	public TbOutstockinfodetailView selectView(Wrapper<TbOutstockinfodetailEntity> wrapper) {
		
		return null;
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TbOutstockinfodetailEntity> wrapper) {
		
		return null;
	}

   

}
