package com.freeter.modules.stock.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 设备定位信息表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-31 18:04:23
 */
@TableName("tb_devicelocalization")
@ApiModel(value = "TbDevicelocalization")
public class TbDevicelocalizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键",hidden = true)
	private Long id;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 设备号
	 */
						
	@ApiModelProperty(value = "设备号")
	private String devicenumber;
	
	/**
	 * 设备纬度
	 */
						
	@ApiModelProperty(value = "设备纬度")
	private BigDecimal devicelat;
	
	/**
	 * 设备经度
	 */
						
	@ApiModelProperty(value = "设备经度")
	private BigDecimal devicelng;
	
	/**
	 * 定位方式(0GPS1基站)
	 */
						
	@ApiModelProperty(value = "定位方式(0GPS1基站)")
	private Integer locationtype;
	
	/**
	 * 设备定位时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "设备定位时间")
	private Date locationtime;
	
	/**
	 * 是否为无线设备(0有线1无线)
	 */
						
	@ApiModelProperty(value = "是否为无线设备(0有线1无线)")
	private Integer iswireless;
	
	/**
	 * 数据写入时间
	 */
			
	@NotNull (message = "数据写入时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "数据写入时间")
	private Date inserttime;
	
	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：车架号
	 */
	public void setVinnumber(String vinnumber) {
		this.vinnumber = vinnumber;
	}
	/**
	 * 获取：车架号
	 */
	public String getVinnumber() {
		return vinnumber;
	}
	/**
	 * 设置：设备号
	 */
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	/**
	 * 获取：设备号
	 */
	public String getDevicenumber() {
		return devicenumber;
	}
	/**
	 * 设置：设备纬度
	 */
	public void setDevicelat(BigDecimal devicelat) {
		this.devicelat = devicelat;
	}
	/**
	 * 获取：设备纬度
	 */
	public BigDecimal getDevicelat() {
		return devicelat;
	}
	/**
	 * 设置：设备经度
	 */
	public void setDevicelng(BigDecimal devicelng) {
		this.devicelng = devicelng;
	}
	/**
	 * 获取：设备经度
	 */
	public BigDecimal getDevicelng() {
		return devicelng;
	}
	/**
	 * 设置：定位方式(0GPS1基站)
	 */
	public void setLocationtype(Integer locationtype) {
		this.locationtype = locationtype;
	}
	/**
	 * 获取：定位方式(0GPS1基站)
	 */
	public Integer getLocationtype() {
		return locationtype;
	}
	/**
	 * 设置：设备定位时间
	 */
	public void setLocationtime(Date locationtime) {
		this.locationtime = locationtime;
	}
	/**
	 * 获取：设备定位时间
	 */
	public Date getLocationtime() {
		return locationtime;
	}
	/**
	 * 设置：是否为无线设备(0有线1无线)
	 */
	public void setIswireless(Integer iswireless) {
		this.iswireless = iswireless;
	}
	/**
	 * 获取：是否为无线设备(0有线1无线)
	 */
	public Integer getIswireless() {
		return iswireless;
	}
	/**
	 * 设置：数据写入时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：数据写入时间
	 */
	public Date getInserttime() {
		return inserttime;
	}
}
