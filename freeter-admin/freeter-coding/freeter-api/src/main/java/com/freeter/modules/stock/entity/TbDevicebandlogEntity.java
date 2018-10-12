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
 * 设备状态表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-20 14:53:27
 */
@TableName("tb_devicebandlog")
@ApiModel(value = "TbDevicebandlog")
public class TbDevicebandlogEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbDevicebandlogEntity() {
		
	}
	
	public TbDevicebandlogEntity(T t) {
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
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 经销商Id
	 */
						
	@ApiModelProperty(value = "经销商Id")
	private String dealerid;
	
	/**
	 * 最后定位纬度
	 */
						
	@ApiModelProperty(value = "最后定位纬度")
	private BigDecimal lastlat;
	
	/**
	 * 最后定位经度
	 */
						
	@ApiModelProperty(value = "最后定位经度")
	private BigDecimal lastlng;
	
	/**
	 * 最后一次定位时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "最后一次定位时间")
	private Date lastlocattime;
	
	/**
	 * 数据写入时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "数据写入时间")
	private Date inserttime;
	
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
	 * 设置：最后定位纬度
	 */
	public void setLastlat(BigDecimal lastlat) {
		this.lastlat = lastlat;
	}
	/**
	 * 获取：最后定位纬度
	 */
	public BigDecimal getLastlat() {
		return lastlat;
	}
	/**
	 * 设置：最后定位经度
	 */
	public void setLastlng(BigDecimal lastlng) {
		this.lastlng = lastlng;
	}
	/**
	 * 获取：最后定位经度
	 */
	public BigDecimal getLastlng() {
		return lastlng;
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
