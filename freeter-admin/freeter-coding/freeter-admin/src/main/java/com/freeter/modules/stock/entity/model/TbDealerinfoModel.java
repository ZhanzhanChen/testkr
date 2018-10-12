package com.freeter.modules.stock.entity.model;

import com.freeter.modules.stock.entity.TbDealerinfoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 经销商信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-25 09:26:23
 */
@ApiModel(value = "TbDealerinfoModel")
public class TbDealerinfoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
						
	@ApiModelProperty(value = "经销商信息主键",hidden = true)
	private String dealerid;
	
	/**
	 * 所属金融机构Id
	 */
						
	@ApiModelProperty(value = "所属金融机构Id")
	private String deptid;
	
	/**
	 * 经销商名称
	 */
						
	@ApiModelProperty(value = "经销商名称")
	private String name;
	
	
	/**
	 * 根经销商
	 */
	@ApiModelProperty(value = "根经销商")
	private String rootdealerid;
	
	
	/**
	 * 经销商等级(字典表)
	 */
						
	@ApiModelProperty(value = "经销商等级(字典表)")
	private String grade;
	
	/**
	 * 省份Code
	 */
						
	@ApiModelProperty(value = "省份Code")
	private String procode;
	
	/**
	 * 省份名称
	 */
						
	@ApiModelProperty(value = "省份名称")
	private String proname;
	
	
	
	
						
	@ApiModelProperty(value = "")
	private String recordaddr;
	
	/**
	 * 库存车辆数量
	 */
						
	@ApiModelProperty(value = "库存车辆数量")
	private Integer stocknum;
	
	/**
	 * 管理人员Code
	 */
						
	@ApiModelProperty(value = "管理人员Code")
	private String managercode;
	
	/**
	 * 管理人员名称
	 */
						
	@ApiModelProperty(value = "管理人员名称")
	private String managername;
	
	/**
	 * 管理人员联系方式
	 */
						
	@ApiModelProperty(value = "管理人员联系方式")
	private String managertel;
	
	
	/**
	 * 上级经销商id
	 */
						
	@ApiModelProperty(value = "上级经销商id")
	private String parentid;
	
	/**
	 * 经销商code
	 */
						
	@ApiModelProperty(value = "经销商code")
	private String code;
	
	
	@ApiModelProperty(value = "报警规则主键",hidden = true)
	private String dealeruleid;
	
	
	public String getDealeruleid() {
		return dealeruleid;
	}

	public void setDealeruleid(String dealeruleid) {
		this.dealeruleid = dealeruleid;
	}

	public Integer getRuletype() {
		return ruletype;
	}

	public void setRuletype(Integer ruletype) {
		this.ruletype = ruletype;
	}

	public String getRulevalue() {
		return rulevalue;
	}

	public void setRulevalue(String rulevalue) {
		this.rulevalue = rulevalue;
	}

	public String getRuleunit() {
		return ruleunit;
	}

	public void setRuleunit(String ruleunit) {
		this.ruleunit = ruleunit;
	}

	/**
	 * 规则类型(0低电压1违规入2违规出)
	 */
						
	@ApiModelProperty(value = "规则类型(0低电压1违规入2违规出)")
	private Integer ruletype;
	
	/**
	 * 预警值
	 */
						
	@ApiModelProperty(value = "预警值")
	private String rulevalue;
	
	/**
	 * 单位
	 */
						
	@ApiModelProperty(value = "单位")
	private String ruleunit;
	
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	
	/**
	 * 设置：所属金融机构Id
	 */
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	/**
	 * 获取：所属金融机构Id
	 */
	public String getDeptid() {
		return deptid;
	}
	/**
	 * 设置：经销商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：经销商名称
	 */
	public String getName() {
		return name;
	}
	
	public String getRootdealerid() {
		return rootdealerid;
	}

	public void setRootdealerid(String rootdealerid) {
		this.rootdealerid = rootdealerid;
	}

	/**
	 * 设置：经销商等级(字典表)
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * 获取：经销商等级(字典表)
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 设置：省份Code
	 */
	public void setProcode(String procode) {
		this.procode = procode;
	}
	/**
	 * 获取：省份Code
	 */
	public String getProcode() {
		return procode;
	}
	/**
	 * 设置：省份名称
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}
	/**
	 * 获取：省份名称
	 */
	public String getProname() {
		return proname;
	}
	
	/**
	 * 设置：
	 */
	public void setRecordaddr(String recordaddr) {
		this.recordaddr = recordaddr;
	}
	/**
	 * 获取：
	 */
	public String getRecordaddr() {
		return recordaddr;
	}
	/**
	 * 设置：库存车辆数量
	 */
	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}
	/**
	 * 获取：库存车辆数量
	 */
	public Integer getStocknum() {
		return stocknum;
	}
	/**
	 * 设置：管理人员Code
	 */
	public void setManagercode(String managercode) {
		this.managercode = managercode;
	}
	/**
	 * 获取：管理人员Code
	 */
	public String getManagercode() {
		return managercode;
	}
	/**
	 * 设置：管理人员名称
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}
	/**
	 * 获取：管理人员名称
	 */
	public String getManagername() {
		return managername;
	}
	/**
	 * 设置：管理人员联系方式
	 */
	public void setManagertel(String managertel) {
		this.managertel = managertel;
	}
	/**
	 * 获取：管理人员联系方式
	 */
	public String getManagertel() {
		return managertel;
	}

	public String getDealerid() {
		return dealerid;
	}

	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}

	
}
