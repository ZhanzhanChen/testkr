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
 * VIEW
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 19:27:39
 */
@TableName("vi_devicebandlog")
@ApiModel(value = "ViDevicebandlog")
public class ViDevicebandlogEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ViDevicebandlogEntity() {
		
	}
	
	public ViDevicebandlogEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 自增主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "自增主键",hidden = true)
	private Long id;
	
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
