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

package com.freeter.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.freeter.form.LoginUserForm;
import com.freeter.modules.sys.entity.SysRoleEntity;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.entity.view.SysUserRoleDeptView;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * 
 * @author czz
 * @date 2018.8.7
 */
public interface SysUserService extends IService<SysUserEntity> {
	
	/**
	 * 查询用户信息
	 * @param username
	 * @return
	 */
	SysUserEntity queryByUsername(String username);

	/**
	 * 查询用户信息
	 * @param userId
	 * @return
	 */
	SysUserEntity queryByUserId(Long userId);
	
	/**
	 * 登录查询
	 * @param form
	 * @return
	 */
	SysUserEntity login(LoginUserForm form);
	
	/**
	 * 查询菜单id
	 * @param userId
	 * @return
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 锁定
	 * @param userName 用户名
	 */
	void updateStatus(String userName);
	
	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);
	
	/**
	 * 查询用户角色信息
	 * @param userId 用户ID
	 * @return
	 */
	List<SysUserRoleDeptView> queryRoleNameByUserId(Long userId);
}
