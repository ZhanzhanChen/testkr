package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;

import com.freeter.modules.stock.dao.BasicDistrictDao;
import com.freeter.modules.stock.entity.BasicDistrictEntity;
import com.freeter.modules.stock.service.BasicDistrictService;



@Service("basicDistrictService")
public class BasicDistrictServiceImpl extends ServiceImpl<BasicDistrictDao, BasicDistrictEntity> implements BasicDistrictService {
	@Autowired
	BasicDistrictDao basicDistrictDao;
	
	@Override
	public List<BasicDistrictEntity> selectListByLevelNo(String levelno) {
		
		return basicDistrictDao.selectListByLevelNo(levelno);
	}

    
}
