package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbDealerinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 经销商信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:24:06
 */
@TableName("tb_dealerinfo")
@ApiModel(value = "TbDealerinfo")
public class TbDealerinfoView  extends TbDealerinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbDealerinfoView(){
	}
 
 	public TbDealerinfoView(TbDealerinfoEntity tbDealerinfoEntity){
 	try {
			BeanUtils.copyProperties(this, tbDealerinfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
