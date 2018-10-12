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
 * 特殊入库明细表
 * 数据库通用操作实体类（普通增删改查）
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
@TableName("tb_instockinfodetail")
@ApiModel(value = "TbInstockinfodetail")
public class TbInstockinfodetailEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbInstockinfodetailEntity() {
		
	}
	
	public TbInstockinfodetailEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(ID)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(ID)",hidden = true)
	private String id;
	
	/**
	 * 入库单Id
	 */
						
	@ApiModelProperty(value = "入库单Id")
	private String instockid;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
						
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)")
	private Integer carstatus;
	
	/**
	 * 签收时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "签收时间")
	private Date receivetime;
	
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
	 * 设置：主键(ID)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(ID)
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：入库单Id
	 */
	public void setInstockid(String instockid) {
		this.instockid = instockid;
	}
	/**
	 * 获取：入库单Id
	 */
	public String getInstockid() {
		return instockid;
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
	 * 设置：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	public void setCarstatus(Integer carstatus) {
		this.carstatus = carstatus;
	}
	/**
	 * 获取：车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
	public Integer getCarstatus() {
		return carstatus;
	}
	/**
	 * 设置：签收时间
	 */
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	/**
	 * 获取：签收时间
	 */
	public Date getReceivetime() {
		return receivetime;
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
