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

package com.freeter.modules.sys.controller;


import com.freeter.common.utils.R;
import com.freeter.common.utils.RedisUtils;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.modules.sys.shiro.ShiroUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录相关
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@Controller
@Api(tags="登录接口")
public class SysLoginController {
	@Autowired
	private Producer producer;
    @Value("${logincount}")
    private int loginCount;
    @Value("${loginPW}")
    private String loginPW;
    @Autowired
    private SysUserService sysUserService;
	
	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
	}
	
	/**
	 * 登录raw
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	@ApiOperation(value="登录",notes="系统登录")
	public R login(@RequestBody SysUserEntity user) {
//	public R login(String username, String password, String captcha) {
//		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//		if(!captcha.equalsIgnoreCase(kaptcha)){
//			return R.error("验证码不正确");
//		}
		String username=user.getUsername();
		String password=user.getPassword();
		try{
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);

//			String sessionID= subject.getSession().getId().toString();//返回sessionID
		}catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			
			//密码错误限制次数，锁定
			if(null != ShiroUtils.getSessionAttribute(username)){
				int tmp =Integer.valueOf(ShiroUtils.getSessionAttribute(username).toString());
				if(tmp>loginCount){
					sysUserService.updateStatus(username);
					return R.error("密码输入超过"+loginCount+"次，账号已被锁定");
				}
				ShiroUtils.setSessionAttribute(username, tmp+1);
			}else{
				ShiroUtils.setSessionAttribute(username, 1);
			}
			
			return R.error("账号或密码不正确");
		}catch (LockedAccountException e) {
			return R.error("账号已被锁定,请联系管理员");
		}catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	    
		//登录成功删除缓存
		if(null != ShiroUtils.getSessionAttribute(username)){
			ShiroUtils.removeSessionAttribute(username);
		}
		
		//初始密码修改提示
		if(password.equals(loginPW)){
			return R.ok("请更改初始密码");
		}else{
			return R.ok();
		}
		
//		return R.ok();
	}
	
	/**
	 * 退出
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.html";
	}
	
	/**
	 * 登录请求格式form-data
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/loginjson", method = RequestMethod.POST)
	public R loginJson(String username, String password) {
		try{
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);

//			String sessionID= subject.getSession().getId().toString();//返回sessionID
		}catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			
			//密码错误限制次数，锁定
			if(null != ShiroUtils.getSessionAttribute(username)){
				int tmp =Integer.valueOf(ShiroUtils.getSessionAttribute(username).toString());
				if(tmp>loginCount){
					sysUserService.updateStatus(username);
					return R.error("密码输入超过"+loginCount+"次，账号已被锁定");
				}
				ShiroUtils.setSessionAttribute(username, tmp+1);
			}else{
				ShiroUtils.setSessionAttribute(username, 1);
			}
			
			return R.error("账号或密码不正确");
		}catch (LockedAccountException e) {
			return R.error("账号已被锁定,请联系管理员");
		}catch (AuthenticationException e) {
			return R.error("账户验证失败");
		}
	    
		//登录成功删除缓存
		if(null != ShiroUtils.getSessionAttribute(username)){
			ShiroUtils.removeSessionAttribute(username);
		}
		
		return R.ok();
	}
	
}
