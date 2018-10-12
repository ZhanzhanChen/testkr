package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.RpFcdatadailyEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.RpFcdatadailyView;


/**
 * 统计分析
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 18:04:27
 */
public interface RpFcdatadailyDao extends BaseMapper<RpFcdatadailyEntity> {
	
	List<RpFcdatadailyView> selectListView(@Param("ew") Wrapper<RpFcdatadailyEntity> wrapper);

	List<RpFcdatadailyView> selectListView(Pagination page,@Param("ew") Wrapper<RpFcdatadailyEntity> wrapper);
	
	RpFcdatadailyView selectView(@Param("ew") Wrapper<RpFcdatadailyEntity> wrapper);
}
