package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.RpFcdatadailyEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;


/**
 * 统计分析
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 18:04:27
 */
public interface RpFcdatadailyService extends IService<RpFcdatadailyEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RpFcdatadailyEntity> wrapper);
   	
   	List<RpFcdatadailyEntity> querylist(Map<String, Object> params,Wrapper<RpFcdatadailyEntity> wrapper);
}

