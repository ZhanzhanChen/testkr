package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.ViDevicebandlogEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * VIEW
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 19:27:39
 */
@TableName("vi_devicebandlog")
@ApiModel(value = "ViDevicebandlog")
public class ViDevicebandlogView  extends ViDevicebandlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ViDevicebandlogView(){
	}
 
 	public ViDevicebandlogView(ViDevicebandlogEntity viDevicebandlogEntity){
 	try {
			BeanUtils.copyProperties(this, viDevicebandlogEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
