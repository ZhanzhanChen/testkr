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
import com.freeter.modules.stock.dao.ViCarcirculationDao;
import com.freeter.modules.stock.entity.ViCarcirculationEntity;
import com.freeter.modules.stock.service.ViCarcirculationService;


@Service("viCarcirculationService")
public class ViCarcirculationServiceImpl extends ServiceImpl<ViCarcirculationDao, ViCarcirculationEntity> implements ViCarcirculationService {

}
