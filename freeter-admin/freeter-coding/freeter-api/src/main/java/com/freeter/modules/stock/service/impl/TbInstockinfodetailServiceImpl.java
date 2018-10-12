package com.freeter.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.utils.PageUtils;

import com.freeter.modules.stock.dao.TbInstockinfoDao;
import com.freeter.modules.stock.dao.TbInstockinfoDetailDao;
import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;
import com.freeter.modules.stock.service.TbInstockinfodetailService;


@Service("tbInstockinfodetailService")
public class TbInstockinfodetailServiceImpl extends ServiceImpl<TbInstockinfoDetailDao,TbInstockinfodetailEntity> implements TbInstockinfodetailService {

	 @Autowired
	 private TbInstockinfoDetailDao tbInstockinfoDetailDao;

	@Override
	public PageUtils selectinstockinfoDetailListByStatus(Page<TbInstockinfodetailEntity> page,Map<String, String> map) {
		page.setRecords(tbInstockinfoDetailDao.selectinstockinfoDetailListByStatus(page,map));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
		
	}
   
}
