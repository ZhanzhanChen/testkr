package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;
import com.freeter.modules.stock.entity.view.TbInstockinfoView;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;



/**
 * 特殊入库明细表
 *
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
public interface TbInstockinfodetailService extends IService<TbInstockinfodetailEntity> {

	PageUtils selectinstockinfoDetailListByStatus(Page<TbInstockinfodetailEntity> page, Map<String, String> map);
	
    
}

