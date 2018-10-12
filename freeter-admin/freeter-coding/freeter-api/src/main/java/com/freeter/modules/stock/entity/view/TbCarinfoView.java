package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbCarinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 车辆信息表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2018-08-17 11:25:30
 */
@TableName("tb_carinfo")
@ApiModel(value = "TbCarinfo")
public class TbCarinfoView  extends TbCarinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbCarinfoView(){
	}
 
 	public TbCarinfoView(TbCarinfoEntity tbCarinfoEntity){
 	try {
			BeanUtils.copyProperties(this, tbCarinfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
