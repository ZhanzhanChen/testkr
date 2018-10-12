package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.ViCarstatusinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.io.Serializable;
 

/**
 * VIEW
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-13 16:31:38
 */
@TableName("vi_carstatusinfo")
@ApiModel(value = "ViCarstatusinfo")
public class ViCarstatusinfoView  extends ViCarstatusinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ViCarstatusinfoView(){
	}
 
 	public ViCarstatusinfoView(ViCarstatusinfoEntity viCarstatusinfoEntity){
 	try {
			BeanUtils.copyProperties(this, viCarstatusinfoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
 	
 	private List<PolygonView> polygon;

	public List<PolygonView> getPolygon() {
		return polygon;
	}

	public void setPolygon(List<PolygonView> polygon) {
		this.polygon = polygon;
	}
 	
}
