package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbDevicebandlogEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbDevicebandlogView;


/**
 * 设备状态表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 14:53:27
 */
public interface TbDevicebandlogDao extends BaseMapper<TbDevicebandlogEntity> {
	
	List<TbDevicebandlogView> selectListView(@Param("ew") Wrapper<TbDevicebandlogEntity> wrapper);

	List<TbDevicebandlogView> selectListView(Pagination page,@Param("ew") Wrapper<TbDevicebandlogEntity> wrapper);
	
	TbDevicebandlogView selectView(@Param("ew") Wrapper<TbDevicebandlogEntity> wrapper);
}
