package com.freeter.modules.sys.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.freeter.common.utils.PageUtils;
import com.freeter.modules.sys.entity.SysRoleEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.freeter.modules.sys.entity.view.SysRoleView;


/**
 * 角色
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-20 16:56:09
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
   	
   	List<SysRoleView> selectListView(Wrapper<SysRoleEntity> wrapper);
   	
   	SysRoleView selectView(@Param("ew") Wrapper<SysRoleEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SysRoleEntity> wrapper);
}

