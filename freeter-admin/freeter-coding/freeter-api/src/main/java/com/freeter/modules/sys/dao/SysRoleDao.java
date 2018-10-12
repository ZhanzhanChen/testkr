package com.freeter.modules.sys.dao;

import com.freeter.modules.sys.entity.SysRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.freeter.modules.sys.entity.view.SysRoleView;


/**
 * 角色
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-20 16:56:09
 */
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	List<SysRoleView> selectListView(@Param("ew") Wrapper<SysRoleEntity> wrapper);

	List<SysRoleView> selectListView(Pagination page,@Param("ew") Wrapper<SysRoleEntity> wrapper);
	
	SysRoleView selectView(@Param("ew") Wrapper<SysRoleEntity> wrapper);
}
