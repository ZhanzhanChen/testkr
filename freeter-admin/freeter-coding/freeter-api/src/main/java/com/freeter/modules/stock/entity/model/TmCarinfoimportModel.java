package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.TmCarinfoimportEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 发车信息导入临时表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-08-17 09:19:09
 */
@ApiModel(value = "TmCarinfoimportModel")
public class TmCarinfoimportModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 数据行号
	 */
	
	@ApiModelProperty(value = "数据行号") 
	private Integer rowno;
		
	/**
	 * 导入人员Id
	 */
	
	@ApiModelProperty(value = "导入人员Id") 
	private Long userid;
		
	/**
	 * 部门Id
	 */
	
	@ApiModelProperty(value = "部门Id") 
	private Long departid;
		
	/**
	 * 经销商名称
	 */
	
	@ApiModelProperty(value = "经销商名称") 
	private String dealername;
		
	/**
	 * 车架号
	 */
	
	@ApiModelProperty(value = "车架号") 
	private String vinnumber;
		
	/**
	 * 是否成功(0否1是)
	 */
	
	@ApiModelProperty(value = "是否成功(0否1是)") 
	private Integer issuccess;
		
	/**
	 * 备注
	 */
	
	@ApiModelProperty(value = "备注") 
	private String remark;
		
	/**
	 * 写入时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	@ApiModelProperty(value = "写入时间") 
	private Date inserttime;
				
	
	/**
	 * 设置：数据行号
	 */
	 
	public void setRowno(Integer rowno) {
		this.rowno = rowno;
	}
	
	/**
	 * 获取：数据行号
	 */
	public Integer getRowno() {
		return rowno;
	}
				
	
	/**
	 * 设置：导入人员Id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：导入人员Id
	 */
	public Long getUserid() {
		return userid;
	}
				
	
	/**
	 * 设置：部门Id
	 */
	 
	public void setDepartid(Long departid) {
		this.departid = departid;
	}
	
	/**
	 * 获取：部门Id
	 */
	public Long getDepartid() {
		return departid;
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
	 * 设置：是否成功(0否1是)
	 */
	 
	public void setIssuccess(Integer issuccess) {
		this.issuccess = issuccess;
	}
	
	/**
	 * 获取：是否成功(0否1是)
	 */
	public Integer getIssuccess() {
		return issuccess;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
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
			
}
