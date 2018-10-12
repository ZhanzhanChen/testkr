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
 * @date 2018-09-26 14:09:59
 */
@TableName("vi_flowstep")
@ApiModel(value = "ViFlowstep")
public class ViFlowstepEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ViFlowstepEntity() {
		
	}
	
	public ViFlowstepEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 流程步骤自增编号
	 */
	
	@TableId 					
	@ApiModelProperty(value = "流程步骤自增编号",hidden = true)
	private Long stepid;
	
	/**
	 * 流程编号
	 */
			
	@NotNull (message = "流程编号不能为空") 				
	@ApiModelProperty(value = "流程编号")
	private Long flowid;
	
	/**
	 * 步骤编号
	 */
			
	@NotNull (message = "步骤编号不能为空") 				
	@ApiModelProperty(value = "步骤编号")
	private Long actionno;
	
	/**
	 * 流程名称
	 */
						
	@ApiModelProperty(value = "流程名称")
	private String flowtile;
	
	/**
	 * 流程步骤名称
	 */
						
	@ApiModelProperty(value = "流程步骤名称")
	private String actiontitle;
	
	/**
	 * 排序号
	 */
						
	@ApiModelProperty(value = "排序号")
	private Integer orderno;
	
	/**
	 * 类型(0顺序,1并行)
	 */
						
	@ApiModelProperty(value = "类型(0顺序,1并行)")
	private Integer typeno;
	
	/**
	 * 流程标记(0开始1过程中2结束)
	 */
						
	@ApiModelProperty(value = "流程标记(0开始1过程中2结束)")
	private Integer flag;
	
	/**
	 * 前一个状态
	 */
						
	@ApiModelProperty(value = "前一个状态")
	private Integer preno;
	
	/**
	 * 流程步骤名称
	 */
						
	@ApiModelProperty(value = "流程步骤名称")
	private String pretitle;
	
	/**
	 * 部门编号
	 */
						
	@ApiModelProperty(value = "部门编号")
	private Long departid;
	
	/**
	 * 设置：流程步骤自增编号
	 */
	public void setStepid(Long stepid) {
		this.stepid = stepid;
	}
	/**
	 * 获取：流程步骤自增编号
	 */
	public Long getStepid() {
		return stepid;
	}
	/**
	 * 设置：流程编号
	 */
	public void setFlowid(Long flowid) {
		this.flowid = flowid;
	}
	/**
	 * 获取：流程编号
	 */
	public Long getFlowid() {
		return flowid;
	}
	/**
	 * 设置：步骤编号
	 */
	public void setActionno(Long actionno) {
		this.actionno = actionno;
	}
	/**
	 * 获取：步骤编号
	 */
	public Long getActionno() {
		return actionno;
	}
	/**
	 * 设置：流程名称
	 */
	public void setFlowtile(String flowtile) {
		this.flowtile = flowtile;
	}
	/**
	 * 获取：流程名称
	 */
	public String getFlowtile() {
		return flowtile;
	}
	/**
	 * 设置：流程步骤名称
	 */
	public void setActiontitle(String actiontitle) {
		this.actiontitle = actiontitle;
	}
	/**
	 * 获取：流程步骤名称
	 */
	public String getActiontitle() {
		return actiontitle;
	}
	/**
	 * 设置：排序号
	 */
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getOrderno() {
		return orderno;
	}
	/**
	 * 设置：类型(0顺序,1并行)
	 */
	public void setTypeno(Integer typeno) {
		this.typeno = typeno;
	}
	/**
	 * 获取：类型(0顺序,1并行)
	 */
	public Integer getTypeno() {
		return typeno;
	}
	/**
	 * 设置：流程标记(0开始1过程中2结束)
	 */
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	/**
	 * 获取：流程标记(0开始1过程中2结束)
	 */
	public Integer getFlag() {
		return flag;
	}
	/**
	 * 设置：前一个状态
	 */
	public void setPreno(Integer preno) {
		this.preno = preno;
	}
	/**
	 * 获取：前一个状态
	 */
	public Integer getPreno() {
		return preno;
	}
	/**
	 * 设置：流程步骤名称
	 */
	public void setPretitle(String pretitle) {
		this.pretitle = pretitle;
	}
	/**
	 * 获取：流程步骤名称
	 */
	public String getPretitle() {
		return pretitle;
	}
	/**
	 * 设置：部门编号
	 */
	public void setDepartid(Long departid) {
		this.departid = departid;
	}
	/**
	 * 获取：部门编号
	 */
	public Long getDepartid() {
		return departid;
	}
}
