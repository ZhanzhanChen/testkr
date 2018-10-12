package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.ViFlowstepEntity;

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
 * @date 2018-09-26 14:09:59
 */
@TableName("vi_flowstep")
@ApiModel(value = "ViFlowstep")
public class ViFlowstepView  extends ViFlowstepEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ViFlowstepView(){
	}
 
 	public ViFlowstepView(ViFlowstepEntity viFlowstepEntity){
 	try {
			BeanUtils.copyProperties(this, viFlowstepEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
