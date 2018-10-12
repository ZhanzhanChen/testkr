package com.freeter.modules.stock.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.stock.entity.ViFlowstepEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.stock.entity.view.ViFlowstepView;


/**
 * VIEW
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-26 14:09:59
 */
public interface ViFlowstepService extends IService<ViFlowstepEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<ViFlowstepView> selectListView(Wrapper<ViFlowstepEntity> wrapper);
   	
   	ViFlowstepView selectView(@Param("ew") Wrapper<ViFlowstepEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ViFlowstepEntity> wrapper);
}

