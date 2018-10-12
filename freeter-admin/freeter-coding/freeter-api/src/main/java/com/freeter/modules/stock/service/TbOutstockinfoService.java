package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbOutstockinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.model.TbOutstockinfoModel;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import com.freeter.modules.stock.entity.view.TbInstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfoView;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;


/**
 * 特殊出库单表
 *
 * @author ipx
 * @email 
 * @date 2018-08-08 13:53:29
 */
public interface TbOutstockinfoService extends IService<TbOutstockinfoEntity> {

	PageUtils selectoutstockinfoList(Page<TbOutstockinfoView> page, Map<String, String> map);
	
	List<TbOutstockinfoView> selectoutstockinfoListById(Map<String, String> map);
	
	R saveTbOutstockinfo(TbOutstockinfoModel outstockinfoModel);
	
	R auditOutstockinfo(Map<String, String> map);
	
	List<TbOutstockinfoView> selectoutstockinfoList(Map<String, String> map);
	
	PageUtils selectoutstockinfoList(Map<String, Object> params, Wrapper<TbOutstockinfoEntity> wrapper);
	
	List<TbOutstockinfoView> selectoutstockList(Map<String,String> map,Wrapper<TbOutstockinfoEntity> wrapper);
}

