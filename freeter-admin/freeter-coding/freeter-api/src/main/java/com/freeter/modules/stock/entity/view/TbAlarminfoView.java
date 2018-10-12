package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbAlarminfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预警日志表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 17:41:59
 */
@TableName("tb_alarminfo")
@ApiModel(value = "TbAlarminfo")
public class TbAlarminfoView  extends TbAlarminfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbAlarminfoView(){
	}
 
 	public TbAlarminfoView(TbAlarminfoEntity tbAlarminfoEntity){
 	try {
			BeanUtils.copyProperties(this, tbAlarminfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
