package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.ViDevicebandlogEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViDevicebandlogView;


/**
 * VIEW
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 19:27:39
 */
public interface ViDevicebandlogDao extends BaseMapper<ViDevicebandlogEntity> {
	
	List<ViDevicebandlogView> selectListView(@Param("ew") Wrapper<ViDevicebandlogEntity> wrapper);

	List<ViDevicebandlogView> selectListView(Pagination page,@Param("ew") Wrapper<ViDevicebandlogEntity> wrapper);
	
	ViDevicebandlogView selectView(@Param("ew") Wrapper<ViDevicebandlogEntity> wrapper);
}
