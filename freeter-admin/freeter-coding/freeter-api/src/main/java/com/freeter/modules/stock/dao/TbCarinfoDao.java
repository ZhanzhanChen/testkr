package com.freeter.modules.stock.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.freeter.modules.stock.entity.TbCarinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.model.TbCarModel;
import com.freeter.modules.stock.entity.view.TbCarinfoView;



/**
 * 车辆信息表
 * 
 * @author ipx
 * @email  
 * @date 2018-08-07 20:24:56
 */
public interface TbCarinfoDao extends BaseMapper<TbCarinfoEntity> {
	
	List<TbCarModel> selectCarinfoListByStatus(Pagination page,Map map);
	
	List<TbCarModel> selectCarOutstockinfoListByStatus(Pagination page,Map map);
	
	List<TbCarinfoView> selectListView(@Param("ew") Wrapper<TbCarinfoEntity> wrapper);

	List<TbCarinfoView> selectListView(Pagination page,@Param("ew") Wrapper<TbCarinfoEntity> wrapper);
	
	TbCarinfoView selectView(@Param("ew") Wrapper<TbCarinfoEntity> wrapper);
	
	Integer insertEntityList(@Param("list") List<TbCarinfoEntity> list);
	
	List<TbCarModel> selectCarinfoListByStatus(Pagination page,@Param("ew") Wrapper<TbCarModel> wrapper);
	
	List<TbCarModel> selectCarOutstockinfoListByStatus(Pagination page,@Param("ew") Wrapper<TbCarModel> wrapper);
	
	Integer updateCarStatusByVinnumber(List list);
	
	Integer outstockupdateCarStatusByVinnumber(List list);
}
