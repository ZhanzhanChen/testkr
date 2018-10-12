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
import com.freeter.modules.stock.dao.TbDevicestatusDao;
import com.freeter.modules.stock.entity.TbDevicestatusEntity;
import com.freeter.modules.stock.service.TbDevicestatusService;


@Service("tbDevicestatusService")
public class TbDevicestatusServiceImpl extends ServiceImpl<TbDevicestatusDao, TbDevicestatusEntity> implements TbDevicestatusService {
	
}
