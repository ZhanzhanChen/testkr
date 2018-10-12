package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.ViDevicebandlogEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViDevicebandlogView;


/**
 * VIEW
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 19:27:39
 */
public interface ViDevicebandlogService extends IService<ViDevicebandlogEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ViDevicebandlogView> selectListView(Wrapper<ViDevicebandlogEntity> wrapper);
   	
   	ViDevicebandlogView selectView(@Param("ew") Wrapper<ViDevicebandlogEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ViDevicebandlogEntity> wrapper);
}

