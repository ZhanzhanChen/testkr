package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbDevicebandlogEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbDevicebandlogView;


/**
 * 设备状态表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 14:53:27
 */
public interface TbDevicebandlogService extends IService<TbDevicebandlogEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<TbDevicebandlogView> selectListView(Wrapper<TbDevicebandlogEntity> wrapper);
   	
   	TbDevicebandlogView selectView(@Param("ew") Wrapper<TbDevicebandlogEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbDevicebandlogEntity> wrapper);
}

