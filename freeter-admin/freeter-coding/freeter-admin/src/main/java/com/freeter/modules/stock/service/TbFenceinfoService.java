package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;

import java.util.List;
import java.util.Map;



/**
 * 围栏信息表
 *
 * @author ipx
 * @email 2112014974@qq.com
 * @date 2018-07-30 13:44:52
 */
public interface TbFenceinfoService extends IService<TbFenceinfoEntity> {
	
	 TbFenceinfoEntity selectTbFenceinfoById(String id);

	 int saveTbFenceinfo(TbFenceinfoEntity tbFenceinfo);

	 String callFenceinfo(Map<String,String> map);


	 PageUtils selectFenceinfoList(Page<TbFenceinfoView> page, Map<String, String> map); 
    
}

