package com.freeter.modules.sys.entity.model;

import com.freeter.modules.sys.entity.SysRoleEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 角色
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-20 16:56:09
 */
@ApiModel(value = "SysRoleModel")
public class SysRoleModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 设置：角色名称
	 */
	 
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/**
	 * 获取：角色名称
	 */
	public String getRoleName() {
		return roleName;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
				
	
	/**
	 * 设置：部门ID
	 */
	 
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
	/**
	 * 获取：部门ID
	 */
	public Long getDeptId() {
		return deptId;
	}
						
	
	/**
	 * 设置：0(看自己)1（看自己和下级）
	 */
	 
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
	
	/**
	 * 获取：0(看自己)1（看自己和下级）
	 */
	public Integer getDataType() {
		return dataType;
	}
			
}
