package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbRemindinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 消息提醒表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-21 16:10:42
 */
@TableName("tb_remindinfo")
@ApiModel(value = "TbRemindinfo")
public class TbRemindinfoView  extends TbRemindinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbRemindinfoView(){
	}
 
 	public TbRemindinfoView(TbRemindinfoEntity tbRemindinfoEntity){
 	try {
			BeanUtils.copyProperties(this, tbRemindinfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
