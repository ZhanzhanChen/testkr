package com.freeter.modules.stock.dao;

import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.model.TbDealerinfoModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;



/**
 * 经销商信息
 * 
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-25 09:26:23
 */
public interface TbDealerinfoDao extends BaseMapper<TbDealerinfoEntity> {
	
	

	List<TbDealerinfoEntity> selectDealer(Map<String, String> params);
	
}
