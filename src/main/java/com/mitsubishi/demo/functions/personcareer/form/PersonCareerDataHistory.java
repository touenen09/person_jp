package com.mitsubishi.demo.functions.personcareer.form;

import java.util.List;

public class PersonCareerDataHistory {

	private PersonJobHistoryTableExt personJobHistoryTableExt;

	private List<PersonCareerDataExt> personCareerDataExtHistoryList;

	public PersonJobHistoryTableExt getPersonJobHistoryTableExt() {
		return personJobHistoryTableExt;
	}

	public void setPersonJobHistoryTableExt(PersonJobHistoryTableExt personJobHistoryTableExt) {
		this.personJobHistoryTableExt = personJobHistoryTableExt;
	}

	public List<PersonCareerDataExt> getPersonCareerDataExtHistoryList() {
		return personCareerDataExtHistoryList;
	}

	public void setPersonCareerDataExtHistoryList(List<PersonCareerDataExt> personCareerDataExtHistoryList) {
		this.personCareerDataExtHistoryList = personCareerDataExtHistoryList;
	}

}
