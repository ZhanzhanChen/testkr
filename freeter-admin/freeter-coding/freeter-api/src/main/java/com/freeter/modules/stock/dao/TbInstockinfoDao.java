package com.freeter.modules.stock.dao;

import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;



/**
 * 围栏信息表
 * 
 * @author ipx
 * @email 
 * @date 2018-07-30 13:44:52
 */
public interface TbInstockinfoDao extends BaseMapper<TbInstockinfoEntity> {
	 
	List<TbInstockinfoView>selectTbInstockinfoList(Pagination page,Map map);

	List<TbInstockinfoView> selectinstockinfoListById(Map<String, String> map);

	Integer saveInstockinfo(TbInstockinfoModel instockinfoModel);
	
	List<TbInstockinfoView>selectTbInstockinfoList(Map map);

	Integer auditInstockinfo(Map<String, String> map);

	List<TbInstockinfoView> selectTbInstockinfoList(Pagination page,@Param("ew") Wrapper<TbInstockinfoEntity> wrapper);
	
	List<TbInstockinfoView>selectTbInstockinfoList(@Param("ew") Wrapper<TbInstockinfoEntity> wrapper);
	
	List<Map>selectVinnumberByInstockId(Map map);
	
	Integer updateCarStatusByInstock(Map map);
}
