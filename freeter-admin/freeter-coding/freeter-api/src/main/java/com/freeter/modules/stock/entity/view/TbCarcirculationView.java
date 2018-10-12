package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbCarcirculationEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 车辆流转表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:34:33
 */
@TableName("tb_carcirculation")
@ApiModel(value = "TbCarcirculation")
public class TbCarcirculationView  extends TbCarcirculationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbCarcirculationView(){
	}
 
 	public TbCarcirculationView(TbCarcirculationEntity tbCarcirculationEntity){
 	try {
			BeanUtils.copyProperties(this, tbCarcirculationEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
