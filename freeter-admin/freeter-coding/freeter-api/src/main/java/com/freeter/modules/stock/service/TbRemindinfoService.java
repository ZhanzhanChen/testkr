package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import com.freeter.modules.stock.entity.TbRemindinfoEntity;
import com.freeter.modules.stock.entity.ViFlowstepEntity;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbRemindinfoView;
import com.freeter.modules.sys.entity.SysUserEntity;


/**
 * 消息提醒表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 16:10:42
 */
public interface TbRemindinfoService extends IService<TbRemindinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<TbRemindinfoView> selectListView(Map<String, String> map,EntityWrapper<TbRemindinfoEntity> ew);
   	
   	TbRemindinfoView selectView(@Param("ew") Wrapper<TbRemindinfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbRemindinfoEntity> wrapper);
   	
   	/**
   	 * 更新已读状态，经销商车辆监管
   	 * @param map
   	 * @return
   	 */
   	Boolean updateAllIsread(Map<String, Object> map);
   	
   	/**
   	 * 处理状态标记
   	 * @param entity
   	 * @return
   	 */
   	Boolean handle(TbRemindinfoEntity entity);
   	
   	/**
   	 * 批量处理报警
   	 * @param list
   	 * @return
   	 */
   	Boolean batchhandle(List<TbRemindinfoEntity>list);
   	
   	/**
   	 * 根据vin码批量处理报警和设备状态
   	 * @param list
   	 * @return
   	 */
   	List<TbCarcirculationEntity> handleRemindByVin(List<String> list, List<ViFlowstepEntity> listFlow, SysUserEntity sysUserEntity);
}

