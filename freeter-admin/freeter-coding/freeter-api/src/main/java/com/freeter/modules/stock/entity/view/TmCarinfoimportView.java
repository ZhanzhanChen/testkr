package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TmCarinfoimportEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 发车信息导入临时表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 09:19:09
 */
@TableName("tm_carinfoimport")
@ApiModel(value = "TmCarinfoimport")
public class TmCarinfoimportView  extends TmCarinfoimportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TmCarinfoimportView(){
	}
 
 	public TmCarinfoimportView(TmCarinfoimportEntity tmCarinfoimportEntity){
 	try {
			BeanUtils.copyProperties(this, tmCarinfoimportEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
