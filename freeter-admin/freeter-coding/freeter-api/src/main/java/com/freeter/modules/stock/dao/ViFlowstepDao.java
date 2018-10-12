package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.ViFlowstepEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViFlowstepView;


/**
 * VIEW
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-26 14:09:59
 */
public interface ViFlowstepDao extends BaseMapper<ViFlowstepEntity> {
	List<ViFlowstepView> selectListView(@Param("ew") Wrapper<ViFlowstepEntity> wrapper);

	List<ViFlowstepView> selectListView(Pagination page,@Param("ew") Wrapper<ViFlowstepEntity> wrapper);
	
	ViFlowstepView selectView(@Param("ew") Wrapper<ViFlowstepEntity> wrapper);
}
