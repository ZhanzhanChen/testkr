package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;



/**
 * 围栏信息表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 13:44:52
 */
public interface TbFenceinfoDao extends BaseMapper<TbFenceinfoEntity> {
	
	TbFenceinfoEntity selectTbFenceinfoById(String id);

	int saveTbFenceinfo(TbFenceinfoEntity tbFenceinfo);
	
	void callFenceinfo(Map<String,String> map);
	
	List<TbFenceinfoView> selectFenceinfoList(Pagination page,Map map);
}
