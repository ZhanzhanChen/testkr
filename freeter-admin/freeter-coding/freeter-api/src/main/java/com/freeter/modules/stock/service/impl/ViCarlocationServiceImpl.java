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

import com.freeter.modules.stock.dao.ViCarlocationDao;
import com.freeter.modules.stock.entity.ViCarlocationEntity;
import com.freeter.modules.stock.service.ViCarlocationService;



@Service("viCarlocationService")
public class ViCarlocationServiceImpl extends ServiceImpl<ViCarlocationDao, ViCarlocationEntity> implements ViCarlocationService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ViCarlocationEntity> wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

   

}
