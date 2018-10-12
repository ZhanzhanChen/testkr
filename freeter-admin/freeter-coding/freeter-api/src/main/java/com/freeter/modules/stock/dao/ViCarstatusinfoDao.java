package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViCarstatusinfoView;


/**
 * VIEW
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-13 16:31:38
 */
public interface ViCarstatusinfoDao extends BaseMapper<ViCarstatusinfoEntity> {
	
	List<ViCarstatusinfoView> selectListView(Pagination page,@Param("ew") Wrapper<ViCarstatusinfoEntity> wrapper);
	
	ViCarstatusinfoEntity selectOneByVinnumber(@Param("ew") Wrapper<ViCarstatusinfoEntity> wrapper);
	
	List<TbFenceinfoEntity> queryFenceinfoList(@Param("ew") Wrapper<TbFenceinfoEntity> wrapper);
}
