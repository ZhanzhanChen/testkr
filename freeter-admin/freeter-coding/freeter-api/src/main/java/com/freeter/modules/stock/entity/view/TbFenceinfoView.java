package com.freeter.modules.stock.entity.view;

import com.freeter.modules.stock.entity.TbFenceinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
 

/**
 * 围栏信息表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author ipx
 * @email 
 * @date 
 */
@TableName("tb_fenceinfo")
@ApiModel(value = "TbFenceinfo")
public class TbFenceinfoView  implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键(FC)",hidden = true)
	private String id;
	@ApiModelProperty(value = "审核状态(0提交1审核通过2拒绝)")
	private Integer auditstate;
	@ApiModelProperty(value = "围栏名称")
	private String fencename;
	@ApiModelProperty(value = "是否启用(0禁用1启用)")
	private Integer isenable;
	/*@NotNull (message = "创建时间不能为空") */			
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	@ApiModelProperty(value = "创建时间")
	private Date createdat;
	@ApiModelProperty(value = "经销商名称")
	private String dealername;
	@ApiModelProperty(value = "围栏信息")
	private List fencePoints;
	@ApiModelProperty(value = "审批详情")
	private String auditRemark;
	@ApiModelProperty(value = "围栏")
	private String fencepolygon;
	
	@ApiModelProperty(value = "经销商等级")
	private String levelcode;
	
	public String getLevelcode() {
		return levelcode;
	}
	public void setLevelcode(String levelcode) {
		this.levelcode = levelcode;
	}
	public String getFencepolygon() {
		return fencepolygon;
	}
	public void setFencepolygon(String fencepolygon) {
		this.fencepolygon = fencepolygon;
	}
	public List getFencePoints() {
		return fencePoints;
	}
	public void setFencePoints(List fencePoints) {
		this.fencePoints = fencePoints;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	public String getFenceAddr() {
		return fenceAddr;
	}
	public void setFenceAddr(String fenceAddr) {
		this.fenceAddr = fenceAddr;
	}
	private String fenceAddr;
	
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	private String dealerName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getAuditstate() {
		return auditstate;
	}
	public void setAuditstate(Integer auditstate) {
		this.auditstate = auditstate;
	}
	public String getFencename() {
		return fencename;
	}
	public void setFencename(String fencename) {
		this.fencename = fencename;
	}
	public Integer getIsenable() {
		return isenable;
	}
	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	
}
