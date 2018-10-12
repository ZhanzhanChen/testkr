package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbOutstockinfodetailEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbOutstockinfodetailView;


/**
 * 特殊出库明细
 *
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
public interface TbOutstockinfodetailService extends IService<TbOutstockinfodetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<TbOutstockinfodetailView> selectListView(Wrapper<TbOutstockinfodetailEntity> wrapper);
   	
   	TbOutstockinfodetailView selectView(@Param("ew") Wrapper<TbOutstockinfodetailEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbOutstockinfodetailEntity> wrapper);
}

