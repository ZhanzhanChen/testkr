package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbCarcirculationEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbCarcirculationView;


/**
 * 车辆流转表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:34:33
 */
public interface TbCarcirculationService extends IService<TbCarcirculationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TbCarcirculationView> selectListView(Wrapper<TbCarcirculationEntity> wrapper);
   	
   	TbCarcirculationView selectView(@Param("ew") Wrapper<TbCarcirculationEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbCarcirculationEntity> wrapper);
}

