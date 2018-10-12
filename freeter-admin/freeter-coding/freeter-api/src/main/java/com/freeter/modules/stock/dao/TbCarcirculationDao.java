package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbCarcirculationView;


/**
 * 车辆流转表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:34:33
 */
public interface TbCarcirculationDao extends BaseMapper<TbCarcirculationEntity> {
	
	List<TbCarcirculationView> selectListView(@Param("ew") Wrapper<TbCarcirculationEntity> wrapper);

	List<TbCarcirculationView> selectListView(Pagination page,@Param("ew") Wrapper<TbCarcirculationEntity> wrapper);
	
	TbCarcirculationView selectView(@Param("ew") Wrapper<TbCarcirculationEntity> wrapper);
}
