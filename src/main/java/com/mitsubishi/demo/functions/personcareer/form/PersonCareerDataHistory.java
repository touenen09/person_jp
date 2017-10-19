package com.mitsubishi.demo.functions.personcareer.form;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;

public class PersonCareerDataHistory {

	private PersonJobHistoryTable personJobHistoryTable;

	private List<PersonCareerDataExt> personCareerDataExtHistoryList;

	public PersonJobHistoryTable getPersonJobHistoryTable() {
		return personJobHistoryTable;
	}

	public void setPersonJobHistoryTable(PersonJobHistoryTable personJobHistoryTable) {
		this.personJobHistoryTable = personJobHistoryTable;
	}

	public List<PersonCareerDataExt> getPersonCareerDataExtHistoryList() {
		return personCareerDataExtHistoryList;
	}

	public void setPersonCareerDataExtHistoryList(List<PersonCareerDataExt> personCareerDataExtHistoryList) {
		this.personCareerDataExtHistoryList = personCareerDataExtHistoryList;
	}

}
