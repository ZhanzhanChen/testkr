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
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 设备状态表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-28 16:54:34
 */
@TableName("tb_devicestatus")
@ApiModel(value = "TbDevicestatus")
public class TbDevicestatusEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbDevicestatusEntity() {
		
	}
	
	public TbDevicestatusEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设备号主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "设备号主键",hidden = true)
	private String devicenumber;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 设备工作状态(0正常1异常)
	 */
			
	@NotNull (message = "设备工作状态(0正常1异常)不能为空") 				
	@ApiModelProperty(value = "设备工作状态(0正常1异常)")
	private Integer devicestatus;
	
	/**
	 * 是否为无线设备(0有线1无线)
	 */
						
	@ApiModelProperty(value = "是否为无线设备(0有线1无线)")
	private Integer iswireless;
	
	/**
	 * 经销商Id
	 */
						
	@ApiModelProperty(value = "经销商Id")
	private String dealerid;
	
	/**
	 * 数据写入时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "数据写入时间")
	private Date inserttime;
	
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
	 * 设置：设备工作状态(0正常1异常)
	 */
	public void setDevicestatus(Integer devicestatus) {
		this.devicestatus = devicestatus;
	}
	/**
	 * 获取：设备工作状态(0正常1异常)
	 */
	public Integer getDevicestatus() {
		return devicestatus;
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
	 * 设置：经销商Id
	 */
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	/**
	 * 获取：经销商Id
	 */
	public String getDealerid() {
		return dealerid;
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
