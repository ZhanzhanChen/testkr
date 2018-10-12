package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbInstockinfodetailEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.io.Serializable;
 

/**
 * 特殊入库明细表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2018-08-07 20:24:56
 */
@TableName("tb_instockinfodetail")
@ApiModel(value = "TbInstockinfodetail")
public class TbInstockinfodetailView implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	@ApiModelProperty(value = "车辆状态明细")
	private String carstatus;
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@ApiModelProperty(value = "签收时间")
	private Date receivetime;
	@ApiModelProperty(value = "车辆状态详细信息")
	private String detailstatus;
	public String getVinnumber() {
		return vinnumber;
	}
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	public String getCarstatus() {
		return carstatus;
	}
	public void setCarstatus(String carstatus) {
		this.carstatus = carstatus;
	}
	public Date getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	public String getDetailstatus() {
		return detailstatus;
	}
	public void setDetailstatus(String detailstatus) {
		this.detailstatus = detailstatus;
	}
	
}
