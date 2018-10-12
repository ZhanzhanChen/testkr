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

package com.freeter.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.freeter.common.exception.RRException;
import com.freeter.common.validator.Assert;
import com.freeter.form.LoginUserForm;
import com.freeter.modules.sys.dao.SysUserDao;
import com.freeter.modules.sys.entity.SysRoleEntity;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.entity.view.SysUserRoleDeptView;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.JwtUtil;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private JwtUtil jwtUtils;
	
	@Override
	public SysUserEntity queryByUsername(String username) {
		SysUserEntity sysUserEntity = new SysUserEntity();
		sysUserEntity.setUsername(username);
		EntityWrapper<SysUserEntity> ew = new EntityWrapper<SysUserEntity>();
		ew.setEntity(sysUserEntity);
		return sysUserService.selectOne(ew);
	}
	
	@Override
	public SysUserEntity queryByUserId(Long userId) {
		SysUserEntity sysUserEntity = new SysUserEntity();
		sysUserEntity.setUserId(userId);
		EntityWrapper<SysUserEntity> ew = new EntityWrapper<SysUserEntity>();
		ew.setEntity(sysUserEntity);
		return sysUserService.selectOne(ew);
	}
	
	@Override
	public SysUserEntity login(LoginUserForm form) {

		EntityWrapper<SysUserEntity> ew = new EntityWrapper<SysUserEntity>();
		SysUserEntity ue = new SysUserEntity(form);
		// 用户登录
		ew.setEntity(ue);
		ue = this.selectOne(ew);

		SysUserEntity user = queryByUsername(form.getUsername());
		return user;
	}
	
	@Override
	public List<Long> queryAllMenuId(Long userId){
		
		List<Long> userIdList = sysUserDao.queryAllMenuId(userId);
		
		return sysUserDao.queryAllMenuId(userId);
	}
	
	@Override
	public void updateStatus(String userName){
		sysUserDao.updateStatus(userName);
	}
	
	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
    }
	
	public List<SysUserRoleDeptView> queryRoleNameByUserId(Long userId){
		return sysUserDao.queryRoleNameByUserId(userId);
	}

}
