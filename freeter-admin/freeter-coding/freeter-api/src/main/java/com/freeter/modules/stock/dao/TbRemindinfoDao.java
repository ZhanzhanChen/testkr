package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbDevicestatusEntity;
import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbRemindinfoView;


/**
 * 消息提醒表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 16:10:42
 */
public interface TbRemindinfoDao extends BaseMapper<TbRemindinfoEntity> {
	
	List<TbRemindinfoView> selectListView(@Param("ew") Wrapper<TbRemindinfoEntity> wrapper);

	List<TbRemindinfoView> selectListView(Pagination page,@Param("ew") Wrapper<TbRemindinfoEntity> wrapper);
	
	TbRemindinfoView selectView(@Param("ew") Wrapper<TbRemindinfoEntity> wrapper);
	
	int batchUpdate(List<TbDevicestatusEntity> list);
}
