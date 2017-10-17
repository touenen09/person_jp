package com.mitsubishi.demo.functions.person.facade.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.PersonTable;
import com.mitsubishi.demo.common.dataset.PersonTableExample;
import com.mitsubishi.demo.common.service.PersonTableService;
import com.mitsubishi.demo.functions.person.facade.PersonFacade;

@Service
@Transactional
public class PersonFacadeImpl implements PersonFacade {

	@Autowired
	PersonTableService personTableService;

	@Override
	public List<PersonTable> selectByExample() {

		PersonTableExample example = new PersonTableExample();
		return selectByExample(example);
	}

	@Override
	public List<PersonTable> selectByExample(PersonTableExample example) {

		return personTableService.selectByExample(example);
	}

	@Override
	public int insertSelective(PersonTable record) {

		return personTableService.insertSelective(record);
	}

	@Override
	public PersonTable selectByPrimaryKey(String personNum) {

		return personTableService.selectByPrimaryKey(personNum);
	}

	@Override
	public int updateByPrimaryKey(PersonTable record) {

		return personTableService.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(String personNum) {

		return personTableService.deleteByPrimaryKey(personNum);
	}

}
