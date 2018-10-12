package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.TbCarfencestatusEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.TbCarfencestatusView;


/**
 * 车辆围栏状态信息
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-28 11:13:34
 */
public interface TbCarfencestatusService extends IService<TbCarfencestatusEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TbCarfencestatusView> selectListView(Wrapper<TbCarfencestatusEntity> wrapper);
   	
   	TbCarfencestatusView selectView(@Param("ew") Wrapper<TbCarfencestatusEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TbCarfencestatusEntity> wrapper);
}

