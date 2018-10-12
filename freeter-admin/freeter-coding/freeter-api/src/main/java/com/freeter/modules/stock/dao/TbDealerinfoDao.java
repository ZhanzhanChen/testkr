package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbDealerinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;


/**
 * 经销商信息
 * 
 * @author 
 * @email 
 * @date 2018-08-17 11:24:06
 */
public interface TbDealerinfoDao extends BaseMapper<TbDealerinfoEntity> {
	
	List<TbDealerinfoView> selectListView(@Param("ew") Wrapper<TbDealerinfoEntity> wrapper);

	List<TbDealerinfoView> selectListView(Pagination page,@Param("ew") Wrapper<TbDealerinfoEntity> wrapper);
	
	TbDealerinfoView selectView(@Param("ew") Wrapper<TbDealerinfoEntity> wrapper);
	
	List<TbDealerinfoEntity> selectDealer(Map<String, String> params);
	
	List<TbDealerinfoEntity> selectDealer(@Param("ew") Wrapper<TbDealerinfoEntity> wrapper);
}
