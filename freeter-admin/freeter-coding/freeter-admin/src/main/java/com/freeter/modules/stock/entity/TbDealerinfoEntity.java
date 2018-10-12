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
 * 经销商信息
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-25 09:26:23
 */
@TableName("tb_dealerinfo")
@ApiModel(value = "TbDealerinfo")
public class TbDealerinfoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TbDealerinfoEntity() {
		
	}
	
	public TbDealerinfoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键
	 */
	
	@TableId 					
	@ApiModelProperty(value = "主键",hidden = true)
	private String id;
	
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
	 * 创建时间
	 */
					
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
	private Date lastupdate;
	
	/**
	 * 是否删除(0否1是)
	 */
			
	@NotNull (message = "是否删除(0否1是)不能为空") 				
	@ApiModelProperty(value = "是否删除(0否1是)")
	private Integer deleted;
	
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
	 * 设置：主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public String getId() {
		return id;
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
	/**
	 * 设置：创建时间
	 */
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedat() {
		return createdat;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Date getLastupdate() {
		return lastupdate;
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
