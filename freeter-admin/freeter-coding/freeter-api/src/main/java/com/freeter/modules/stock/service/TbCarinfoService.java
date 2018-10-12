package com.freeter.modules.stock.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbCarinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.TbCarModel;
import com.freeter.modules.stock.entity.model.TbCarinfoFenceModel;
import com.freeter.modules.stock.entity.view.TbCarinfoView;



/**
 * 车辆信息表
 *
 * @author ipx
 * @email  
 * @date 2018-08-07 20:24:56
 */
public interface TbCarinfoService extends IService<TbCarinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<TbCarinfoView> selectListView(Wrapper<TbCarinfoEntity> wrapper);
   	
   	TbCarinfoView selectView(@Param("ew") Wrapper<TbCarinfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbCarinfoEntity> wrapper);
   	
   	Integer insertEntityList(@Param("list") List<TbCarinfoEntity> list);
   	
   	/**
   	 * 签入、售出、还款
   	 * @param tbCarinfoList
   	 * @return
   	 */
   	Boolean updateCarStatus(List<ViCarstatusinfoEntity> tbCarinfoList);
   	
   	/**
   	 * 标签入库
   	 * @param tbCarinfoList
   	 * @return
   	 */
   	Boolean updateCarStockIn(TbCarinfoFenceModel tbCarinfoFenceModel);
   	
   	PageUtils selectCarinfoListByStatus(Map<String, Object> params, Wrapper<TbCarModel> wrapper);
   	
   	PageUtils selectCarOutstockinfoListByStatus(Map<String, Object> params, Wrapper<TbCarModel> wrapper);
}

