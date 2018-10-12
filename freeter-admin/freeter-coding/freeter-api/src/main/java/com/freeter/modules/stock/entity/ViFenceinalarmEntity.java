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
 * @date 2018-08-22 11:29:56
 */
@TableName("vi_fenceinalarm")
@ApiModel(value = "ViFenceinalarm")
public class ViFenceinalarmEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ViFenceinalarmEntity() {
		
	}
	
	public ViFenceinalarmEntity(T t) {
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
	 * 所属金融机构Id
	 */
						
	@ApiModelProperty(value = "所属金融机构Id")
	private Long departid;
	
	/**
	 * 主键(DL)
	 */
				
	@NotBlank (message = "主键(DL)不能为空") 			
	@ApiModelProperty(value = "主键(DL)")
	private String dealerid;
	
	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String dealername;
	
	/**
	 * 设备号
	 */
						
	@ApiModelProperty(value = "设备号")
	private String devicenumber;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 围栏名称
	 */
						
	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	
	/**
	 * 报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞)
	 */
						
	@ApiModelProperty(value = "报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞)")
	private Integer alarmtype;
	
	/**
	 * 报警时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "报警时间")
	private Date alarmtime;
	
	/**
	 * 是否已读(是/否)
	 */
			
	@NotNull (message = "是否已读(是/否)不能为空") 				
	@ApiModelProperty(value = "是否已读(是/否)")
	private Integer isread;
	
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
	 * 设置：所属金融机构Id
	 */
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	public Long getDepartid() {
		return departid;
	}

	/**
	 * 设置：主键(DL)
	 */

	public void setDepartid(Long departid) {
		this.departid = departid;
	}

	/**
	 * 获取：主键(DL)
	 */
	public String getDealerid() {
		return dealerid;
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
	 * 设置：围栏名称
	 */
	public void setFencename(String fencename) {
		this.fencename = fencename;
	}
	/**
	 * 获取：围栏名称
	 */
	public String getFencename() {
		return fencename;
	}
	/**
	 * 设置：报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞)
	 */
	public void setAlarmtype(Integer alarmtype) {
		this.alarmtype = alarmtype;
	}
	/**
	 * 获取：报警类型(0出围栏1入围栏2低电压3无信号4非法拆除5震动6位移7碰撞)
	 */
	public Integer getAlarmtype() {
		return alarmtype;
	}
	/**
	 * 设置：报警时间
	 */
	public void setAlarmtime(Date alarmtime) {
		this.alarmtime = alarmtime;
	}
	/**
	 * 获取：报警时间
	 */
	public Date getAlarmtime() {
		return alarmtime;
	}
	/**
	 * 设置：是否已读(是/否)
	 */
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	/**
	 * 获取：是否已读(是/否)
	 */
	public Integer getIsread() {
		return isread;
	}
}
