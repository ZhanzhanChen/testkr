package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbFenceinfoEntity;
import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViCarstatusinfoView;


/**
 * VIEW
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-13 16:31:38
 */
public interface ViCarstatusinfoService extends IService<ViCarstatusinfoEntity> {

   	PageUtils queryPage(Map<String, Object> params,Wrapper<ViCarstatusinfoEntity> wrapper);
   	
   	public List<ViCarstatusinfoEntity> querylist(Map<String, String> params, Wrapper<ViCarstatusinfoEntity> wrapper);
   	
   	ViCarstatusinfoEntity selectOneByVinnumber(@Param("ew") Wrapper<ViCarstatusinfoEntity> wrapper);
   	
   	public PageUtils queryPageDealer(Map<String, Object> params, Wrapper<ViCarstatusinfoEntity> wrapper);
   	
   	List<TbFenceinfoEntity> queryFenceinfoList(Map<String, Object> params, Wrapper<TbFenceinfoEntity> wrapper);
}

