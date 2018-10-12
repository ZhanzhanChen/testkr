package com.freeter.modules.sys.entity.view;

import com.freeter.modules.sys.entity.SysRoleEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 角色
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-20 16:56:09
 */
@TableName("sys_role")
@ApiModel(value = "SysRole")
public class SysRoleView  extends SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SysRoleView(){
	}
 
 	public SysRoleView(SysRoleEntity sysRoleEntity){
 	try {
			BeanUtils.copyProperties(this, sysRoleEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
