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
 * 特殊出库明细
 * 数据库通用操作实体类（普通增删改查）
 * @author ipx
 * @email 
 * @date 2018-08-07 20:24:56
 */
@TableName("tb_outstockinfodetail")
@ApiModel(value = "TbOutstockinfodetail")
public class TbOutstockinfodetailEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbOutstockinfodetailEntity() {
		
	}
	
	public TbOutstockinfodetailEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(OD)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(OD)",hidden = true)
	private String id;
	
	/**
	 * 出库单Id
	 */
						
	@ApiModelProperty(value = "出库单Id")
	private String outstockid;
	
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
	 * 围栏名称
	 */
						
	@ApiModelProperty(value = "围栏名称")
	private String fenceid;
	
	/**
	 * 围栏名称
	 */
						
	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	
	/**
	 * 数据更新时间
	 */
			
	@NotNull (message = "数据更新时间不能为空") 			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "数据更新时间")
	private Date inserttime;
	
	/**
	 * 是否删除(0否1是)
	 */
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
	/**
	 * 设置：主键(OD)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(OD)
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：出库单Id
	 */
	public void setOutstockid(String outstockid) {
		this.outstockid = outstockid;
	}
	/**
	 * 获取：出库单Id
	 */
	public String getOutstockid() {
		return outstockid;
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
	 * 设置：围栏名称
	 */
	public void setFenceid(String fenceid) {
		this.fenceid = fenceid;
	}
	/**
	 * 获取：围栏名称
	 */
	public String getFenceid() {
		return fenceid;
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
	 * 设置：数据更新时间
	 */
	public void setInserttime(Date inserttime) {
		this.inserttime = inserttime;
	}
	/**
	 * 获取：数据更新时间
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
