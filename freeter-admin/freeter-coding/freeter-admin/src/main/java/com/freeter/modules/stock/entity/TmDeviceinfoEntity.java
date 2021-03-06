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
 * 心跳电压/电量临时表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-02 18:07:10
 */
@TableName("tm_deviceinfo")
@ApiModel(value = "TmDeviceinfo")
public class TmDeviceinfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "自增主键",hidden = true)
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
	 * 是否为无线设备(0有线1无线)
	 */
						
	@ApiModelProperty(value = "是否为无线设备(0有线1无线)")
	private Integer iswireless;
	
	/**
	 * 电压
	 */
						
	@ApiModelProperty(value = "电压")
	private BigDecimal voltage;
	
	/**
	 * 电池电量
	 */
						
	@ApiModelProperty(value = "电池电量")
	private BigDecimal batterypct;
	
	/**
	 * 写入时间
	 */
			
	@NotNull (message = "写入时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "写入时间")
	private Date inserttime;
	
	/**
	 * 是否删除(0否1是)
	 */
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
	/**
	 * 设置：自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
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
	 * 设置：电压
	 */
	public void setVoltage(BigDecimal voltage) {
		this.voltage = voltage;
	}
	/**
	 * 获取：电压
	 */
	public BigDecimal getVoltage() {
		return voltage;
	}
	/**
	 * 设置：电池电量
	 */
	public void setBatterypct(BigDecimal batterypct) {
		this.batterypct = batterypct;
	}
	/**
	 * 获取：电池电量
	 */
	public BigDecimal getBatterypct() {
		return batterypct;
	}
	/**
	 * 设置：写入时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：写入时间
	 */
	public Date getInserttime() {
		return inserttime;
	}
	/**
	 * 设置：是否删除(0否1是)
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：是否删除(0否1是)
	 */
	public Integer getDeleted() {
		return deleted;
	}
}
