package com.mitsubishi.demo.functions.personcareer.form;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.entity.ListInfo;

public class PersonCareerDataExt extends PersonCareerData {

	private String endDateString;

	private String startDateString;

	private List<ListInfo> seleteProduct;

	private List<ListInfo> seleteProductDetail;

	private List<ListInfo> seleteFunction;

	private List<ListInfo> seleteFunctionDetail;

	private List<ListInfo> seleteLocation;

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public List<ListInfo> getSeleteProduct() {
		return seleteProduct;
	}

	public void setSeleteProduct(List<ListInfo> seleteProduct) {
		this.seleteProduct = seleteProduct;
	}

	public List<ListInfo> getSeleteProductDetail() {
		return seleteProductDetail;
	}

	public void setSeleteProductDetail(List<ListInfo> seleteProductDetail) {
		this.seleteProductDetail = seleteProductDetail;
	}

	public List<ListInfo> getSeleteFunction() {
		return seleteFunction;
	}

	public void setSeleteFunction(List<ListInfo> seleteFunction) {
		this.seleteFunction = seleteFunction;
	}

	public List<ListInfo> getSeleteFunctionDetail() {
		return seleteFunctionDetail;
	}

	public void setSeleteFunctionDetail(List<ListInfo> seleteFunctionDetail) {
		this.seleteFunctionDetail = seleteFunctionDetail;
	}

	public List<ListInfo> getSeleteLocation() {
		return seleteLocation;
	}

	public void setSeleteLocation(List<ListInfo> seleteLocation) {
		this.seleteLocation = seleteLocation;
	}

}
