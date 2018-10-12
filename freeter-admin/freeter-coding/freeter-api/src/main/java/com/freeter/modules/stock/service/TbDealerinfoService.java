package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbDealerinfoEntity;
import com.freeter.modules.stock.entity.TbInstockinfoEntity;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbDealerinfoView;


/**
 * 经销商信息
 *
 * @author 
 * @date 2018-08-17 11:24:06
 */
public interface TbDealerinfoService extends IService<TbDealerinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<TbDealerinfoView> selectListView(Wrapper<TbDealerinfoEntity> wrapper);
   	
   	TbDealerinfoView selectView(@Param("ew") Wrapper<TbDealerinfoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbDealerinfoEntity> wrapper);
   	
   	List<TbDealerinfoEntity> selectDealerList(Map<String, String> params);
   	
   	List<TbDealerinfoEntity>  selectDealerList(Map<String,String> map,Wrapper<TbDealerinfoEntity> wrapper);
}

