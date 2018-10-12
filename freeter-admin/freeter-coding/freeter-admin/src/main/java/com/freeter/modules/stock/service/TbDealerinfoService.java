package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.model.TbDealerinfoModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



/**
 * 经销商信息
 *
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-25 09:26:23
 */
public interface TbDealerinfoService extends IService<TbDealerinfoEntity> {

    
	List<TbDealerinfoEntity> selectDealerList(Map<String, String> params);
}

