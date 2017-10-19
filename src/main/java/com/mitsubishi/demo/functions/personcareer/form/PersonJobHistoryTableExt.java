package com.mitsubishi.demo.functions.personcareer.form;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;

public class PersonJobHistoryTableExt extends PersonJobHistoryTable {

	private String actionName;
	private String actionReasonName;
	private String locationName;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionReasonName() {
		return actionReasonName;
	}

	public void setActionReasonName(String actionReasonName) {
		this.actionReasonName = actionReasonName;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
