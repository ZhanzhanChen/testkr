package com.freeter.modules.stock.entity.view;

import java.io.Serializable;
import java.util.List;

public class SysMenuView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long code;
	
	private Integer parentCode;
	
	private Long parentId;
	
	private String name;
	
	private String ngUrl;
	
	private String targetUrl;
	
	private String icon;
	
	private Boolean visible;
	
	private Integer sortOrder;
	
	private Integer type;
	
	private List<?> children;
	
	private List<?> widgets;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Integer getParentCode() {
		return parentCode;
	}

	public void setParentCode(Integer parentCode) {
		this.parentCode = parentCode;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNgUrl() {
		return ngUrl;
	}

	public void setNgUrl(String ngUrl) {
		this.ngUrl = ngUrl;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<?> getChildren() {
		return children;
	}

	public void setChildren(List<?> children) {
		this.children = children;
	}

	public List<?> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<?> widgets) {
		this.widgets = widgets;
	}
	
	
 	
}
