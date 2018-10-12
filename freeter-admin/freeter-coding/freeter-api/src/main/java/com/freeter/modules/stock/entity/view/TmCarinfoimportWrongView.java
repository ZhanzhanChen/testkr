package com.freeter.modules.stock.entity.view;

import java.io.Serializable;

public class TmCarinfoimportWrongView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer rowno;
	
	private String VinNumber;

	private String DealerName;
	
	private String remark;

	public Integer getRowno() {
		return rowno;
	}

	public void setRowno(Integer rowno) {
		this.rowno = rowno;
	}

	public String getVinNumber() {
		return VinNumber;
	}

	public void setVinNumber(String vinNumber) {
		VinNumber = vinNumber;
	}

	public String getDealerName() {
		return DealerName;
	}

	public void setDealerName(String dealerName) {
		DealerName = dealerName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
