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
 * 车辆流转表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 11:34:33
 */
@TableName("tb_carcirculation")
@ApiModel(value = "TbCarcirculation")
public class TbCarcirculationEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbCarcirculationEntity() {
		
	}
	
	public TbCarcirculationEntity(T t) {
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
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
	
	private String remark;
	
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
