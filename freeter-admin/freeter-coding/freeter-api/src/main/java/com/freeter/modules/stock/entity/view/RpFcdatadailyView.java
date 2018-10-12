package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.RpFcdatadailyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 统计分析
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 18:04:27
 */
@TableName("rp_fcdatadaily")
@ApiModel(value = "RpFcdatadaily")
public class RpFcdatadailyView  extends RpFcdatadailyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RpFcdatadailyView(){
	}
 
 	public RpFcdatadailyView(RpFcdatadailyEntity rpFcdatadailyEntity){
 	try {
			BeanUtils.copyProperties(this, rpFcdatadailyEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
