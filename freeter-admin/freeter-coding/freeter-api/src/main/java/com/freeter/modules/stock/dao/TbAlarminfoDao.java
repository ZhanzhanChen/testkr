package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbAlarminfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbAlarminfoView;


/**
 * 预警日志表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 17:41:59
 */
public interface TbAlarminfoDao extends BaseMapper<TbAlarminfoEntity> {
	
	List<TbAlarminfoView> selectListView(@Param("ew") Wrapper<TbAlarminfoEntity> wrapper);

	List<TbAlarminfoView> selectListView(Pagination page,@Param("ew") Wrapper<TbAlarminfoEntity> wrapper);
	
	TbAlarminfoView selectView(@Param("ew") Wrapper<TbAlarminfoEntity> wrapper);
}
