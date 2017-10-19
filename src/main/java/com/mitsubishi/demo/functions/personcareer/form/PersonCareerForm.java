package com.mitsubishi.demo.functions.personcareer.form;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.functions.person.form.PersonTableForm;

public class PersonCareerForm {

	private PersonTableForm personTableForm;

	// 主務ヘッダ
	private PersonJobHistoryTable personCareerDataSyumuHeader;

	// 主務詳細リスト
	private List<PersonCareerDataExt> personCareerDataSyumuDetailList;

	// 主務歴史ヘッダと詳細リスト,0:ヘッダ,1:詳細
	private List<PersonCareerDataHistory> personCareerDataSyumuHistoryList;

	// 兼務ヘッダ
	private PersonJobHistoryTable personCareerDataKenmuHeader;

	// 兼務詳細リスト
	private List<PersonCareerDataExt> personCareerDataKenmuDetailList;

	public PersonTableForm getPersonTableForm() {
		return personTableForm;
	}

	public void setPersonTableForm(PersonTableForm personTableForm) {
		this.personTableForm = personTableForm;
	}

	public PersonJobHistoryTable getPersonCareerDataSyumuHeader() {
		return personCareerDataSyumuHeader;
	}

	public void setPersonCareerDataSyumuHeader(PersonJobHistoryTable personCareerDataSyumuHeader) {
		this.personCareerDataSyumuHeader = personCareerDataSyumuHeader;
	}

	public List<PersonCareerDataExt> getPersonCareerDataSyumuDetailList() {
		return personCareerDataSyumuDetailList;
	}

	public void setPersonCareerDataSyumuDetailList(List<PersonCareerDataExt> personCareerDataSyumuDetailList) {
		this.personCareerDataSyumuDetailList = personCareerDataSyumuDetailList;
	}

	public List<PersonCareerDataHistory> getPersonCareerDataSyumuHistoryList() {
		return personCareerDataSyumuHistoryList;
	}

	public void setPersonCareerDataSyumuHistoryList(List<PersonCareerDataHistory> personCareerDataSyumuHistoryList) {
		this.personCareerDataSyumuHistoryList = personCareerDataSyumuHistoryList;
	}

	public PersonJobHistoryTable getPersonCareerDataKenmuHeader() {
		return personCareerDataKenmuHeader;
	}

	public void setPersonCareerDataKenmuHeader(PersonJobHistoryTable personCareerDataKenmuHeader) {
		this.personCareerDataKenmuHeader = personCareerDataKenmuHeader;
	}

	public List<PersonCareerDataExt> getPersonCareerDataKenmuDetailList() {
		return personCareerDataKenmuDetailList;
	}

	public void setPersonCareerDataKenmuDetailList(List<PersonCareerDataExt> personCareerDataKenmuDetailList) {
		this.personCareerDataKenmuDetailList = personCareerDataKenmuDetailList;
	}

}
