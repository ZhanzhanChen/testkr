package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.Query;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.dao.TbDealerinfoDao;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.model.TbDealerinfoModel;
import com.freeter.modules.stock.service.TbDealerinfoService;



@Service("tbDealerinfoService")
public class TbDealerinfoServiceImpl extends ServiceImpl<TbDealerinfoDao, TbDealerinfoEntity> implements TbDealerinfoService {

	@Autowired
	private TbDealerinfoDao tbDealerinfoDao;
	


	@Override
	public List<TbDealerinfoEntity> selectDealerList(Map<String, String> params) {
		
		return tbDealerinfoDao.selectDealer(params);
	}

	

	

}
