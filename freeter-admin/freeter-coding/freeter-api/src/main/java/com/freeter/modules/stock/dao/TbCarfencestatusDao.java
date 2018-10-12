package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbCarfencestatusEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbCarfencestatusView;


/**
 * 车辆围栏状态信息
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-28 11:13:34
 */
public interface TbCarfencestatusDao extends BaseMapper<TbCarfencestatusEntity> {
	List<TbCarfencestatusView> selectListView(@Param("ew") Wrapper<TbCarfencestatusEntity> wrapper);

	List<TbCarfencestatusView> selectListView(Pagination page,@Param("ew") Wrapper<TbCarfencestatusEntity> wrapper);
	
	TbCarfencestatusView selectView(@Param("ew") Wrapper<TbCarfencestatusEntity> wrapper);
}
