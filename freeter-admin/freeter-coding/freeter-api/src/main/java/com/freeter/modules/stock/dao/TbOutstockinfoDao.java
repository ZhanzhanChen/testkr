package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfoModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfodetailModel;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;

import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;
import com.freeter.modules.stock.entity.view.ViCarstatusinfoView;


/**
 * 特殊出库单表
 * 
 * @author ipx
 * @email 
 * @date 2018-08-08 13:53:29
 */
public interface TbOutstockinfoDao extends BaseMapper<TbOutstockinfoEntity> {
	
	List<TbOutstockinfoView>selectTbOutstockinfoList(Pagination page,Map map);
	
	List<TbOutstockinfoView> selectoutstockinfoListById(Map<String, String> map);
	
	Integer saveOutstockinfo(TbOutstockinfoModel outstockinfoModel);
	
	Integer auditOutstockinfo(Map<String, String> map);
	
	List<TbOutstockinfoView>selectTbOutstockinfoListExport(Map map);
	
	List<TbOutstockinfoView> selectTbOutstockinfoList(Pagination page,@Param("ew") Wrapper<TbOutstockinfoEntity> wrapper);
	
	List<TbOutstockinfoView>selectTbOutstockinfoList(@Param("ew") Wrapper<TbOutstockinfoEntity> wrapper);
	
    List<Map>selectVinnumberByOutstockId(Map map);
	
	Integer updateCarStatusByOutstock(Map map);
	
	List<Map>selectTimeByVinnumber(List<TbOutstockinfodetailModel> list);
}
