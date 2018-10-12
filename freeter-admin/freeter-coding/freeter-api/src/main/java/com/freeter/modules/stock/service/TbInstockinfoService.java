package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.model.TbInstockinfoModel;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



/**
 * 围栏信息表
 *
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-30 13:44:52
 */
public interface TbInstockinfoService extends IService<TbInstockinfoEntity> {
	
	PageUtils selectinstockinfoList(Page<TbInstockinfoView> page, Map<String, String> map);

	List<TbInstockinfoView> selectinstockinfoListById(Map<String, String> map);

	R saveTbInstockinfo(TbInstockinfoModel instockinfoModel);
    
	List<TbInstockinfoView> selectinstockinfoList(Map<String, String> map);

	R auditInstockinfo(Map<String, String> map);
	
	PageUtils selectinstockinfoList(Map<String, Object> params, Wrapper<TbInstockinfoEntity> wrapper);
	
	List<TbInstockinfoView> selectinstockList(Map<String,String> map,Wrapper<TbInstockinfoEntity> wrapper);
}

