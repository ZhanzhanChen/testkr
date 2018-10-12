package com.freeter.modules.stock.entity.view;

import java.io.Serializable;
import java.util.List;

import com.freeter.common.utils.DateUtils;
import com.freeter.modules.stock.entity.model.LatlngModel;

public class ArchesMoreView implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long ValuesCount;
	
	private String StartDateTime;
	
	private String EndDateTime;
	
	private List<ArchesLocationsView> Locations;
	
	public Long getValuesCount() {
		return ValuesCount;
	}

	public void setValuesCount(Long valuesCount) {
		ValuesCount = valuesCount;
	}

	public List<ArchesLocationsView> getLocations() {
		return Locations;
	}

	public void setLocations(List<ArchesLocationsView> locations) {
		Locations = locations;
	}

	public String getStartDateTime() throws Exception {
		return DateUtils.format(DateUtils.UTCCastDate(StartDateTime),DateUtils.DATE_TIME_PATTERN);
	}

	public void setStartDateTime(String startDateTime) {
		StartDateTime = startDateTime;
	}

	public String getEndDateTime() throws Exception {
		return DateUtils.format(DateUtils.UTCCastDate(EndDateTime),DateUtils.DATE_TIME_PATTERN);
	}

	public void setEndDateTime(String endDateTime) {
		EndDateTime = endDateTime;
	}

	
}
