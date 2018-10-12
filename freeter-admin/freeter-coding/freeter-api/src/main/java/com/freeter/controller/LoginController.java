package com.freeter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.freeter.annotation.Login;
import com.freeter.annotation.SysLog;
import com.freeter.common.exception.RRException;
import com.freeter.common.utils.IPUtils;
import com.freeter.common.utils.R;
import com.freeter.common.validator.Assert;
import com.freeter.common.validator.ValidatorUtils;
import com.freeter.form.LoginUserForm;
import com.freeter.form.PasswordForm;
import com.freeter.modules.stock.entity.SysMenuEntity;
import com.freeter.modules.stock.service.SysMenuService;
import com.freeter.modules.sys.entity.SysUserEntity;
import com.freeter.modules.sys.entity.view.SysUserRoleDeptView;
import com.freeter.modules.sys.service.SysUserService;
import com.freeter.utils.Constant;
import com.freeter.utils.ConvertPwd;
import com.freeter.utils.JwtUtil;
import com.freeter.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;

/**
 * 登录接口
 * @author czz 
 * @date 2018.8.7
 *
 */
@RestController
@Api(tags="登录接口")
@RequestMapping(value="/sys")
public class LoginController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private JwtUtil jwtUtils;
	@Autowired
	private CacheChannel cacheChannel;
	@Value("${login.count}")
	private int loginFalseCount;
	@Value("${login.password}")
	private String password;
	
	/**
	 * 用户登陆
	 * @param form
	 * @param request
	 * @return
	 */
	@PostMapping("login")
	@ApiOperation("用户登录")
	@SysLog("用户登陆")
	public R login(@RequestBody LoginUserForm form, HttpServletRequest request){
        //表单校验
        ValidatorUtils.validateEntity(form);
        SysUserEntity user=sysUserService.queryByUsername(form.getUsername());
		Assert.isNull(user, "用户名或密码错误");
		
		//缓存名称
		String cacheName=form.getUsername().concat("count");
				
		if(1!=user.getStatus()){
			throw new RRException("用户已锁定,请联系管理员");
		}
		
		if(null != form.getUsername() && form.getUsername().equals("admin")){
			System.out.println("IP:" + IPUtils.getIP(request));
			throw new RRException("用户已锁定,请联系管理员");
		}
		
//		if(cacheChannel.exists("login", form.getUsername()+"count")){
//			System.out.println("J2Cache---->>>>>>> KEY:"+cacheChannel.get("login", cacheName).getKey()
//					+"------VALUE:"+cacheChannel.get("login", cacheName).getValue());
//		}
		if (!user.getPassword().equals(new SimpleHash("SHA-256", form.getPassword(), user.getSalt(), 16).toString())) {
			//30分钟内3次密码错误锁定账号
			if(cacheChannel.exists("login", cacheName)){
				//使用j2cache缓存数据
				int loginCount = Integer.valueOf(cacheChannel.get("login", cacheName).getValue().toString());
				if(loginCount >= loginFalseCount - 1){
					sysUserService.updateStatus(user.getUsername());
					//清除缓存
					if(cacheChannel.exists("login", cacheName)){
						cacheChannel.evict("login", cacheName);
					}
					throw new RRException("密码输入超过"+loginFalseCount+"次,账号已锁定");
				} else {
					cacheChannel.set("login", cacheName,loginCount + 1);
					throw new RRException("用户名或密码错误");
				}
			} else {
				cacheChannel.set("login", cacheName,1);
				throw new RRException("用户名或密码错误");
			}
		} 
		//登陆成功删除缓存
		if(cacheChannel.exists("login", cacheName)){
			cacheChannel.evict("login", cacheName);
		}
		//登陆成功设置session
		if(null == request.getAttribute("userId") || StringUtil.isEmpty(request.getAttribute("userId").toString())){
			request.setAttribute("userId", form.getUsername());
		}
		
		String token = jwtUtils.generateToken(user.getUserId());
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		
		//用户菜单权限
		List<SysUserRoleDeptView> list = sysUserService.queryRoleNameByUserId(user.getUserId());
		
		//用户按钮权限
		List<String> buttonlist = sysMenuService.selectButtonList(user.getUserId()); //用户有权限按钮
		EntityWrapper<SysMenuEntity> ew = new EntityWrapper<>();
		ew.eq("type", 2);
		List<SysMenuEntity> menulist =sysMenuService.selectList(ew);//库融系统所有按钮
		Map<String, Object> menuMap = new HashMap<>();
		for(SysMenuEntity menu : menulist){
			if(buttonlist.contains(menu.getName())){
				menuMap.put(menu.getName(), 1);
			}else{
				menuMap.put(menu.getName(), 0);
			}
		}
		
		if(list.get(0).getParentid() == 0){
			map.put("role", "agence");
		}else{
			map.put("role", "dealer");
		}
		
		if(password.equals(form.getPassword())){
			map.put("msg", "请更改初始密码");
		}
		
		map.put("user", list.get(0));
		map.put("rolePermission", menuMap);
        
        return R.ok(map);
    }

	@PostMapping("/password")
	@Login
	@ApiOperation("修改密码")
	public R password(@RequestBody PasswordForm pw, HttpServletRequest request){
		Assert.isBlank(pw.getNewPassword(), "新密码不为能空");
		if(6 > pw.getNewPassword().trim().length()){
			return R.error("新密码长度不能少于6位");
		}
		
		Long userId=(Long)request.getAttribute("userId");
		SysUserEntity user = sysUserService.queryByUserId(userId);
		//原密码
		pw.setPassword(ConvertPwd.sha256(pw.getPassword(), user.getSalt()));
		//新密码
		pw.setNewPassword(ConvertPwd.sha256(pw.getNewPassword(), user.getSalt()));
				
		//更新密码
		boolean flag = sysUserService.updatePassword(userId, pw.getPassword(), pw.getNewPassword());
		if(!flag){
			return R.error("原密码不正确");
		}
		
		if(null != request.getSession().getAttribute(user.getUsername()+"count")){
			request.removeAttribute(user.getUsername()+"count");
		}
		
		return R.ok();
	}
	
}
