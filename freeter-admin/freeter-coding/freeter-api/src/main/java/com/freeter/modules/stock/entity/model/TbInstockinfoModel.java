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
import java.util.List;

import org.springframework.data.geo.Polygon;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;



/**
 * 围栏信息表
 * 数据库通用操作实体类（普通增删改查）
 * @author ipx
 * @email 
 * @date 2018-07-30 13:44:52
 */
@TableName("tb_fenceinfo")
@ApiModel(value = "TbFenceinfo")
public class TbInstockinfoModel<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	
	/**
	 * 主键(FC)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(FC)",hidden = true)
	private String instockid;
	
	/**
	 * 申请经销商Id
	 */
						
	@ApiModelProperty(value = "申请经销商Id")
	private String dealerid;
	
	
	@ApiModelProperty(value = "部门Id")
	private Long departid;
	
	

	public Long getDepartid() {
		return departid;
	}

	public void setDepartid(Long departid) {
		this.departid = departid;
	}

	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String dealername;
	
	/**
	 * 入库数量
	 */
				
	@ApiModelProperty(value = "入库数量")
	private Integer instocknum;
	
	/**
	 * 预计入库时间
	 */
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@ApiModelProperty(value = "预计入库时间")
	private Date instocktime;
	
	/**
	 * 字典表Id
	 */
							
	@ApiModelProperty(value = "字典表Id")
	private Integer instockreason;
	
	
	/**
	 * 审核状态(0提交1审核通过2拒绝)
	 */
						
	@ApiModelProperty(value = "审核状态(0提交1审核通过2拒绝)")
	private Integer auditstate;
	
	/**
	 * 审核时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "审核时间")
	private Date audittime;
	
	/**
	 * 审核意见
	 */
						
	@ApiModelProperty(value = "审核意见")
	private String auditremark;
	
	/**
	 * 备注
	 */
			
					
	@ApiModelProperty(value = "备注")
	private String remark;
	
	/**
	 * 创建时间
	 */
			
	/*@NotNull (message = "创建时间不能为空") */			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "创建时间")
	private Date createdat;
	
	/**
	 * 最后更新时间
	 */
					
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "最后更新时间")
	
	private List<TbInstockinfodetailModel> data;
	
	
	

	public List<TbInstockinfodetailModel> getData() {
		return data;
	}

	public void setData(List<TbInstockinfodetailModel> data) {
		this.data = data;
	}

	private Date lastupdate;

	public String getInstockid() {
		return instockid;
	}

	public void setInstockid(String instockid) {
		this.instockid = instockid;
	}

	public String getDealerid() {
		return dealerid;
	}

	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}

	public String getDealername() {
		return dealername;
	}

	public void setDealername(String dealername) {
		this.dealername = dealername;
	}

	public Integer getInstocknum() {
		return instocknum;
	}

	public void setInstocknum(Integer instocknum) {
		this.instocknum = instocknum;
	}

	public Date getInstocktime() {
		return instocktime;
	}

	public void setInstocktime(Date instocktime) {
		this.instocktime = instocktime;
	}

	public Integer getInstockreason() {
		return instockreason;
	}

	public void setInstockreason(Integer instockreason) {
		this.instockreason = instockreason;
	}

	public Integer getAuditstate() {
		return auditstate;
	}

	public void setAuditstate(Integer auditstate) {
		this.auditstate = auditstate;
	}

	public Date getAudittime() {
		return audittime;
	}

	public void setAudittime(Date audittime) {
		this.audittime = audittime;
	}

	public String getAuditremark() {
		return auditremark;
	}

	public void setAuditremark(String auditremark) {
		this.auditremark = auditremark;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public Date getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	
	


	
}
