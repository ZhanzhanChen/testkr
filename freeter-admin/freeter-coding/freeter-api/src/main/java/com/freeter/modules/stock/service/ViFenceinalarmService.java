package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.ViFenceinalarmEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViFenceinalarmView;


/**
 * VIEW
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 16:11:39
 */
public interface ViFenceinalarmService extends IService<ViFenceinalarmEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<ViFenceinalarmView> selectListView(Wrapper<ViFenceinalarmEntity> wrapper);
   	
   	ViFenceinalarmView selectView(@Param("ew") Wrapper<ViFenceinalarmEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ViFenceinalarmEntity> wrapper);
   	
   	/**
   	 * 金融公司车辆入库消息清理
   	 * @return
   	 */
   	Boolean clean();
   	
   	/**
   	 * 经销商车辆入库消息数量
   	 * @param map
   	 * @return
   	 */
   	Integer selectNoticeCount(Map<String, Object> map);
   	
   	/**
   	 * 经销商车辆入库消息清理
   	 * @return
   	 */
   	Boolean dealerClean(Map<String, Object> map);
   	
   	/**
   	 * 经销商入库列表
   	 * @param map
   	 * @return
   	 */
   	List<ViFenceinalarmEntity> selectDealerList(Map<String, Object> map);
}

