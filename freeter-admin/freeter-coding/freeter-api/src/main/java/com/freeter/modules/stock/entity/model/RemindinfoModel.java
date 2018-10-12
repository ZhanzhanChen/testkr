package com.freeter.modules.stock.entity.model;

import java.io.Serializable;
import java.util.List;

import com.freeter.modules.stock.entity.TbRemindinfoEntity;

public class RemindinfoModel<T> implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	List<TbRemindinfoEntity> selectedList;
	
	int remindstatus;
	
	String remark;

	

	public List<TbRemindinfoEntity> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(List<TbRemindinfoEntity> selectedList) {
		this.selectedList = selectedList;
	}

	public int getRemindstatus() {
		return remindstatus;
	}

	public void setRemindstatus(int remindstatus) {
		this.remindstatus = remindstatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
