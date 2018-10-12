package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbAlarminfoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbAlarminfoView;


/**
 * 预警日志表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 17:41:59
 */
public interface TbAlarminfoService extends IService<TbAlarminfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<TbAlarminfoView> selectListView(Wrapper<TbAlarminfoEntity> wrapper);
   	
   	TbAlarminfoView selectView(@Param("ew") Wrapper<TbAlarminfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbAlarminfoEntity> wrapper);
   	
   	/**
   	 * 更新已读状态，经销商车辆监管
   	 * @param map
   	 * @return
   	 */
   	Boolean updateAllIsread(Map<String, List<Object>> map);
}

