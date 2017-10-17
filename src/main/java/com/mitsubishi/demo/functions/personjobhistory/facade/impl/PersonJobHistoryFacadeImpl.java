package com.mitsubishi.demo.functions.personjobhistory.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample;
import com.mitsubishi.demo.common.service.PersonJobHistoryTableService;
import com.mitsubishi.demo.functions.personjobhistory.facade.PersonJobHistoryFacade;

@Service
public class PersonJobHistoryFacadeImpl implements PersonJobHistoryFacade {

	@Autowired
	PersonJobHistoryTableService personJobHistoryTableService;

	@Override
	public List<PersonJobHistoryTable> selectByExample() {

		PersonJobHistoryTableExample example = new PersonJobHistoryTableExample();

		return selectByExample(example);
	}

	@Override
	public List<PersonJobHistoryTable> selectByExample(PersonJobHistoryTableExample example) {

		return personJobHistoryTableService.selectByExample(example);
	}

}
