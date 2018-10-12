package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbCarfencestatusEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 车辆围栏状态信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-09-28 11:13:34
 */
@TableName("tb_carfencestatus")
@ApiModel(value = "TbCarfencestatus")
public class TbCarfencestatusView  extends TbCarfencestatusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TbCarfencestatusView(){
	}
 
 	public TbCarfencestatusView(TbCarfencestatusEntity tbCarfencestatusEntity){
 	try {
			BeanUtils.copyProperties(this, tbCarfencestatusEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
