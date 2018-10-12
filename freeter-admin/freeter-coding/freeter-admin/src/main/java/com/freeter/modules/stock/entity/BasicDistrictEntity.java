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
 * 基础_行政区划表
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-30 09:13:27
 */
@TableName("basic_district")
@ApiModel(value = "BasicDistrict")
public class BasicDistrictEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public BasicDistrictEntity() {
		
	}
	
	public BasicDistrictEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键(BD)
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键(BD)",hidden = true)
	private String id;
	
	/**
	 * 行政区划Code
	 */
						
	@ApiModelProperty(value = "行政区划Code")
	private String code;
	
	/**
	 * 行政区划名称
	 */
						
	@ApiModelProperty(value = "行政区划名称")
	private String name;
	
	/**
	 * 父级Id
	 */
						
	@ApiModelProperty(value = "父级Id")
	private String parentid;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String parentcode;
	
	/**
	 * 
	 */
						
	@ApiModelProperty(value = "")
	private String parentname;
	
	/**
	 * 行政区划等级:1 省级;2 地市;3 区县
	 */
						
	@ApiModelProperty(value = "行政区划等级:1 省级;2 地市;3 区县")
	private Integer levelno;
	
	/**
	 * 序列号
	 */
						
	@ApiModelProperty(value = "序列号")
	private Integer sortorder;
	
	/**
	 * 是否删除: 0 否;1 是
	 */
						
	@ApiModelProperty(value = "是否删除: 0 否;1 是")
	private Integer deleted;
	
	/**
	 * 设置：主键(BD)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键(BD)
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：行政区划Code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：行政区划Code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：行政区划名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：行政区划名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：父级Id
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：父级Id
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * 设置：
	 */
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
	/**
	 * 获取：
	 */
	public String getParentcode() {
		return parentcode;
	}
	/**
	 * 设置：
	 */
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	/**
	 * 获取：
	 */
	public String getParentname() {
		return parentname;
	}
	/**
	 * 设置：行政区划等级:1 省级;2 地市;3 区县
	 */
	public void setLevelno(Integer levelno) {
		this.levelno = levelno;
	}
	/**
	 * 获取：行政区划等级:1 省级;2 地市;3 区县
	 */
	public Integer getLevelno() {
		return levelno;
	}
	/**
	 * 设置：序列号
	 */
	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}
	/**
	 * 获取：序列号
	 */
	public Integer getSortorder() {
		return sortorder;
	}
	/**
	 * 设置：是否删除: 0 否;1 是
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	/**
	 * 获取：是否删除: 0 否;1 是
	 */
	public Integer getDeleted() {
		return deleted;
	}
}
