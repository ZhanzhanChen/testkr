package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.ViCarlocationEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;


/**
 * VIEW
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-28 09:38:36
 */
public interface ViCarlocationService extends IService<ViCarlocationEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ViCarlocationEntity> wrapper);
}

