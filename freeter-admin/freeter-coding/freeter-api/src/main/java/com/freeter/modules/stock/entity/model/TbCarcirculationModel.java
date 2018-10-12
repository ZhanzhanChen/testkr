package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.TbCarcirculationEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 车辆流转表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:34:33
 */
@ApiModel(value = "TbCarcirculationModel")
public class TbCarcirculationModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 车架号
	 */
	
	@ApiModelProperty(value = "车架号") 
	private String vinnumber;
		
	/**
	 * 业务流程(0车辆数据导入1签收2还款(解除绑定)3解除报警4超时未入库5违规出库6特殊入申请7特殊入审批8特殊出申请9特殊出审批10预警等)
	 */
	
	@ApiModelProperty(value = "业务流程(0车辆数据导入1签收2还款(解除绑定)3解除报警4超时未入库5违规出库6特殊入申请7特殊入审批8特殊出申请9特殊出审批10预警等)") 
	private Integer circutype;
		
	/**
	 * 操作人Id
	 */
	
	@ApiModelProperty(value = "操作人Id") 
	private Long operateid;
		
	/**
	 * 操作人
	 */
	
	@ApiModelProperty(value = "操作人") 
	private String operator;
		
	/**
	 * 处理时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "处理时间") 
	private Date actiontime;
		
	/**
	 * 最后更新时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "最后更新时间") 
	private Date lastupeate;
		
	/**
	 * 是否删除(0否1是)
	 */
	
	@ApiModelProperty(value = "是否删除(0否1是)") 
	private Integer deleted;
				
	
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
	 * 设置：业务流程(0车辆数据导入1签收2还款(解除绑定)3解除报警4超时未入库5违规出库6特殊入申请7特殊入审批8特殊出申请9特殊出审批10预警等)
	 */
	 
	public void setCircutype(Integer circutype) {
		this.circutype = circutype;
	}
	
	/**
	 * 获取：业务流程(0车辆数据导入1签收2还款(解除绑定)3解除报警4超时未入库5违规出库6特殊入申请7特殊入审批8特殊出申请9特殊出审批10预警等)
	 */
	public Integer getCircutype() {
		return circutype;
	}
				
	
	/**
	 * 设置：操作人Id
	 */
	 
	public void setOperateid(Long operateid) {
		this.operateid = operateid;
	}
	
	/**
	 * 获取：操作人Id
	 */
	public Long getOperateid() {
		return operateid;
	}
				
	
	/**
	 * 设置：操作人
	 */
	 
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * 获取：操作人
	 */
	public String getOperator() {
		return operator;
	}
				
	
	/**
	 * 设置：处理时间
	 */
	 
	public void setActiontime(Date actiontime) {
		this.actiontime = actiontime;
	}
	
	/**
	 * 获取：处理时间
	 */
	public Date getActiontime() {
		return actiontime;
	}
				
	
	/**
	 * 设置：最后更新时间
	 */
	 
	public void setLastupeate(Date lastupeate) {
		this.lastupeate = lastupeate;
	}
	
	/**
	 * 获取：最后更新时间
	 */
	public Date getLastupeate() {
		return lastupeate;
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
