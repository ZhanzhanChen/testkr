package com.freeter.modules.stock.dao;

import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;



/**
 * 围栏信息表
 * 
 * @author ipx
 * @email 
 * @date 
 */
public interface TbFenceinfoDao extends BaseMapper<TbFenceinfoEntity> {
	
	TbFenceinfoView selectTbFenceinfoById(String id);

	int saveTbFenceinfo(TbFenceinfoEntity tbFenceinfo);
	
	String callFenceinfo(TbFenceinfoEntity tbFenceinfoEntity);
	
	List<TbFenceinfoView> selectDealerFenceinfoList(Pagination page,Map map);

	int disableTbFenceinfo(Map<String, String> map);

	Map<String,String> getDealerIdByUserId(Long userId);
	
	int carfence(Map map);
	
	Map<String,Object> getDealerById(String dealerId);
	
	Map<String,Long> getDeptIdByUserId(Long userId);
	
	List<TbFenceinfoView> selectFenceinfoList(Pagination page,@Param("ew") Wrapper<TbFenceinfoEntity> wrapper);
	
	Map<String,Object> getDealerLevelByUserId(Long userId);

	List<TbFenceinfoEntity> selectByownDealerId(Map<String, Object> map);
	
}
