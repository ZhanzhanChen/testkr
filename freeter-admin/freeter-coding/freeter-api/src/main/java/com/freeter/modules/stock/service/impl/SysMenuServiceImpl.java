/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.freeter.modules.stock.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.modules.stock.dao.SysMenuDao;
import com.freeter.modules.stock.entity.SysMenuEntity;
import com.freeter.modules.stock.entity.view.SysMenuView;
import com.freeter.modules.stock.service.SysMenuService;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
	@Autowired
	private SysUserService sysUserService;
	
	@Override
	public List<SysMenuView> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenuView> menuList = queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		
		List<SysMenuView> userMenuList = new ArrayList<>();
		for(SysMenuView menu : menuList){
			if(menuIdList.contains(menu.getId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuView> queryListParentId(Long parentId) {
		return baseMapper.queryListParentId(parentId);
	}

	@Override
	public List<SysMenuView> queryNotButtonList() {
		return baseMapper.queryNotButtonList();
	}

	@Override
	public List<SysMenuView> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if(userId == Constant.SUPER_ADMIN){
			return getAllMenuList(null);
		}
		
		//用户菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuView> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<SysMenuView> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuView> getMenuTreeList(List<SysMenuView> menuList, List<Long> menuIdList){
		List<SysMenuView> subMenuList = new ArrayList<SysMenuView>();
		
		for(SysMenuView entity : menuList){
			//目录
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
				entity.setChildren(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		
		return subMenuList;
	}
	
	@Override
	public List<String> selectButtonList(Long userId){
		return baseMapper.selectButtonList(userId);
	}
}
