package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.ViDevicebandlogEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * VIEW
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 19:27:39
 */
@ApiModel(value = "ViDevicebandlogModel")
public class ViDevicebandlogModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 设备号主键
	 */
	
	@ApiModelProperty(value = "设备号主键") 
	private String devicenumber;
		
	/**
	 * 经销商名称
	 */
	
	@ApiModelProperty(value = "经销商名称") 
	private String dealername;
		
	/**
	 * 最后一次定位时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "最后一次定位时间") 
	private Date lastlocattime;
				
	
	/**
	 * 设置：设备号主键
	 */
	 
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	
	/**
	 * 获取：设备号主键
	 */
	public String getDevicenumber() {
		return devicenumber;
	}
				
	
	/**
	 * 设置：经销商名称
	 */
	 
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	
	/**
	 * 获取：经销商名称
	 */
	public String getDealername() {
		return dealername;
	}
				
	
	/**
	 * 设置：最后一次定位时间
	 */
	 
	public void setLastlocattime(Date lastlocattime) {
		this.lastlocattime = lastlocattime;
	}
	
	/**
	 * 获取：最后一次定位时间
	 */
	public Date getLastlocattime() {
		return lastlocattime;
	}
			
}
