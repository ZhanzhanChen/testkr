package com.freeter.modules.stock.entity.model;

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
 * 车辆信息表
 * 数据库通用操作实体类（普通增删改查）
 * @author ipx
 * @email
 * @date 2018-08-07 20:24:56
 */
@TableName("tb_carinfo")
@ApiModel(value = "TbCarinfo")
public class TbCarModel<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	

	/**
	 * 主键(TC)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(TC)",hidden = true)
	private String id;
	
	/**
	 * 车架号
	 */
						
	@ApiModelProperty(value = "车架号")
	private String vinnumber;
	
	/**
	 * 车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)
	 */
						
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)")
	private int carstatus;
	
	
	@ApiModelProperty(value = "车辆状态明细(0在途1已签收2特殊入库3已还款4车辆在库5正常出库6特殊出库7异常出库8.超时未入库)")
	private int detailstatus;
	/**
	 * 所属金融机构Id
	 */
		
	
	@ApiModelProperty(value = "所属金融机构Id")
	private Long departid;
	
	/**
	 * 所属经销商Id
	 */
						
	@ApiModelProperty(value = "所属经销商Id")
	private String dealerid;
	
	/**
	 * 经销商Code
	 */
						
	@ApiModelProperty(value = "经销商Code")
	private String dealercode;
	
	/**
	 * 围栏名称
	 */
	@ApiModelProperty(value = "围栏名称")
	private String fenceid;	
	
	public String getFenceid() {
		return fenceid;
	}

	public void setFenceid(String fenceid) {
		this.fenceid = fenceid;
	}

	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	public String getFencename() {
		return fencename;
	}

	public void setFencename(String fencename) {
		this.fencename = fencename;
	}

	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String dealername;
	
	/**
	 * 签收时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "签收时间")
	private Date receivetime;
	
	/**
	 * 还款时间
	 */
					
	
	/**
	 * 车辆数据导入时间
	 */
	
	/**
	 * 最后更新时间
	 */
					
	
	/**
	 * 是否删除(0否1是)
	 */
			
	
	/**
	 * 设置：主键(TC)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(TC)
	 */
	public String getId() {
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
	 * 设置：所属金融机构Id
	 */
	public void setDepartid(Long departid) {
		this.departid = departid;
	}
	/**
	 * 获取：所属金融机构Id
	 */
	public Long getDepartid() {
		return departid;
	}
	/**
	 * 设置：所属经销商Id
	 */
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	/**
	 * 获取：所属经销商Id
	 */
	public String getDealerid() {
		return dealerid;
	}
	/**
	 * 设置：经销商Code
	 */
	public void setDealercode(String dealercode) {
		this.dealercode = dealercode;
	}
	/**
	 * 获取：经销商Code
	 */
	public String getDealercode() {
		return dealercode;
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
	 * 设置：还款时间
	 */

	public int getCarstatus() {
		return carstatus;
	}

	public void setCarstatus(int carstatus) {
		this.carstatus = carstatus;
	}

	public int getDetailstatus() {
		return detailstatus;
	}

	public void setDetailstatus(int detailstatus) {
		this.detailstatus = detailstatus;
	}

	
}
