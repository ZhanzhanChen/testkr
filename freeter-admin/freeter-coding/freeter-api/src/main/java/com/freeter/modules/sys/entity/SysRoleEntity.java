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

package com.freeter.modules.sys.entity;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:27:38
 */
@TableName("sys_role")
@ApiModel(value = "SysRole")
public class SysRoleEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public SysRoleEntity() {
		
	}
	
	public SysRoleEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 角色ID
	 */
	@TableId
	@ApiModelProperty(value = "主键",hidden = true)
	private Long roleId;

	/**
	 * 角色名称
	 */
	@ApiModelProperty(value = "角色名称")
	private String roleName;

	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 部门ID
	 */
	@ApiModelProperty(value = "部门ID")
	private Long deptId;

	/**
	 * 0(看自己)1（看自己和下级）
	 */
	
	@ApiModelProperty(value = "0(看自己)1（看自己和下级）") 
	private Integer dataType;
	
	/**
	 * 部门名称
	 */
	@TableField(exist=false)
	private String deptName;

	@TableField(exist=false)
	private List<Long> menuIdList;
	@TableField(exist=false)
	private List<Long> deptIdList;
	
	/**
	 * 创建时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 			
	@TableField(fill = FieldFill.INSERT) 
	@ApiModelProperty(value = "创建时间",hidden = true)
	private Date createTime;

	/**
	 * 设置：
	 * @param roleId 
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public Long getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：角色名称
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 获取：角色名称
	 * @return String
	 */
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * 设置：备注
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取：备注
	 * @return String
	 */
	public String getRemark() {
		return remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Long> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<Long> menuIdList) {
		this.menuIdList = menuIdList;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Long> getDeptIdList() {
		return deptIdList;
	}

	public void setDeptIdList(List<Long> deptIdList) {
		this.deptIdList = deptIdList;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
}
