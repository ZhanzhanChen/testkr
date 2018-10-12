package com.freeter.modules.stock.entity.view;

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
import java.util.ArrayList;
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
@TableName("tb_Instockinfo")
@ApiModel(value = "TbInstockinfo")
public class TbInstockinfoView<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbInstockinfoView() {
		
	}
	
	public TbInstockinfoView(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "id")
	private String id;
	
	@ApiModelProperty(value = "审核状态")
	private String instockauditstate;
	
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
	private String auditstate;
	
	
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
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	@ApiModelProperty(value = "创建时间")
	private Date createdat;
	@ApiModelProperty(value = "入库原因")
	private String reason;
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
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

	public String getInstockauditstate() {
		return instockauditstate;
	}

	public void setInstockauditstate(String instockauditstate) {
		this.instockauditstate = instockauditstate;
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

	public String getAuditstate() {
		return auditstate;
	}

	public void setAuditstate(String auditstate) {
		this.auditstate = auditstate;
	}

	List<TbInstockinfodetailView> list = new ArrayList<TbInstockinfodetailView>();

	public List<TbInstockinfodetailView> getList() {
		return list;
	}

	public void setList(List<TbInstockinfodetailView> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	


	
	
}
