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

package com.freeter.modules.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

import com.freeter.annotation.Login;
import com.freeter.common.annotation.J2CacheEvit;
import com.freeter.common.exception.RRException;
import com.freeter.common.utils.HttpContextUtils;
import com.freeter.common.utils.R;
import com.freeter.interceptor.AuthorizationInterceptor;
import com.freeter.modules.stock.entity.SysMenuEntity;
import com.freeter.modules.stock.entity.view.SysMenuView;
import com.freeter.modules.stock.service.SysMenuService;
import com.freeter.utils.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 系统菜单
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:58:15
 */
@RestController
@RequestMapping("/sys/menu")
@Api(tags="菜单接口")
public class SysMenuController{
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 导航菜单
	 */
	@RequestMapping(value="/nav", method= RequestMethod.POST)
	@ApiOperation(value="导航菜单",notes="获取导航菜单")
	@Login
	public R nav(HttpServletRequest request){
		Long userId=Long.parseLong(request.getAttribute(AuthorizationInterceptor.USER_KEY).toString());
		List<SysMenuView> menuList = sysMenuService.getUserMenuList(Long.parseLong(request.getAttribute(AuthorizationInterceptor.USER_KEY).toString()));
		return R.ok().put("menuList", menuList);
	}
	
	/**
	 * 所有菜单列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:menu:list")
	public List<SysMenuEntity> list(){
		List<SysMenuEntity> menuList = sysMenuService.selectList(null);
		for(SysMenuEntity sysMenuEntity : menuList){
			SysMenuEntity parentMenuEntity = sysMenuService.selectById(sysMenuEntity.getParentId());
			if(parentMenuEntity != null){
				sysMenuEntity.setParentName(parentMenuEntity.getName());
			}
		}
		return menuList;
	}
	
	/**
	 * 选择菜单(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:menu:select")
	public R select(){
		//查询列表数据
		List<SysMenuView> menuList = sysMenuService.queryNotButtonList();
		
		//添加顶级菜单
		SysMenuView root = new SysMenuView();
		root.setId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
//		root.setOpen(true);
		menuList.add(root);
		
		return R.ok().put("menuList", menuList);
	}
	
	/**
	 * 菜单信息
	 */
	@RequestMapping("/info/{menuId}")
	@RequiresPermissions("sys:menu:info")
	public R info(@PathVariable("menuId") Long menuId){
		SysMenuEntity menu = sysMenuService.selectById(menuId);
		return R.ok().put("menu", menu);
	}
	
	public R queryButtonList(){
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		Long userId = Long.valueOf(request.getAttribute("userId").toString());
		List<String> list = sysMenuService.selectButtonList(userId);
		return R.ok().put("button", list);
	}

}
