package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.ViFenceinalarmEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViFenceinalarmView;


/**
 * VIEW
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 16:11:39
 */
public interface ViFenceinalarmDao extends BaseMapper<ViFenceinalarmEntity> {
	List<ViFenceinalarmView> selectListView(@Param("ew") Wrapper<ViFenceinalarmEntity> wrapper);

	List<ViFenceinalarmView> selectListView(Pagination page,@Param("ew") Wrapper<ViFenceinalarmEntity> wrapper);
	
	ViFenceinalarmView selectView(@Param("ew") Wrapper<ViFenceinalarmEntity> wrapper);
}
