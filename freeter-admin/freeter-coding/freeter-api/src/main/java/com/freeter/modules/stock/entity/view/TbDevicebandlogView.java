package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbDevicebandlogEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 设备状态表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 14:53:27
 */
@TableName("tb_devicebandlog")
@ApiModel(value = "TbDevicebandlog")
public class TbDevicebandlogView  extends TbDevicebandlogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbDevicebandlogView(){
	}
 
 	public TbDevicebandlogView(TbDevicebandlogEntity tbDevicebandlogEntity){
 	try {
			BeanUtils.copyProperties(this, tbDevicebandlogEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
