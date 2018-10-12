package com.freeter.modules.sys.entity.view;

import java.io.Serializable;

public class SysUserRoleDeptView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 用户状态
	 */
	private Integer status;
	/**
	 * 部门ID
	 */
	private Long deptid;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 电话号码
	 */
	private String mobile;
	/**
	 * 用户ID
	 */
	private Long userid;
	/**
	 * 邮件
	 */
	private String email;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 角色名称
	 */
	private String rolename;
	/**
	 * 上级部门ID
	 */
	private Long parentid;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDeptid() {
		return deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	
}
