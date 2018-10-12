package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.common.utils.R;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;
import com.freeter.modules.stock.entity.view.PolygonView;
import com.freeter.modules.stock.entity.view.TbFenceinfoView;

import java.util.List;
import java.util.Map;



/**
 * 围栏信息表
 *
 * @author ipx
 * @email 2112014974@qq.com
 * @date 
 */
public interface TbFenceinfoService extends IService<TbFenceinfoEntity> {
	
	TbFenceinfoView selectTbFenceinfoById(String id);

	int saveTbFenceinfo(TbFenceinfoEntity tbFenceinfo);

	String callFenceinfo(TbFenceinfoEntity tbFenceinfoEntity);
	 
	PageUtils selectFenceinfoList(Page<TbFenceinfoView> page, Map<String, String> map);

	R disableTbFenceinfo(Map<String, String> map);

	Map<String,String> getDealerIdByUserId(Long userId);

	R ableTbFenceinfo(Map<String, String> map);

	Map<String,Object> getDealerById(String dealerId);
	
	Map<String,Long> getDeptIdByUserId(Long userId);
    
	PageUtils selectFenceinfoList(Map<String,Object> map,Wrapper<TbFenceinfoEntity> wrapper);
	
	Map<String,Object> getDealerLevelByUserId(Long userId);
	
	List<TbFenceinfoEntity> selectFenceinfoByDistance(String dealerid,PolygonView polygonView);
}

