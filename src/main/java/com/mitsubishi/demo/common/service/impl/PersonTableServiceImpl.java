package com.mitsubishi.demo.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.PersonTable;
import com.mitsubishi.demo.common.dataset.PersonTableExample;
import com.mitsubishi.demo.common.mapper.PersonTableMapper;
import com.mitsubishi.demo.common.service.PersonTableService;

@Service
public class PersonTableServiceImpl implements PersonTableService {

	@Autowired
	PersonTableMapper personTableMapper;

	@Override
	public long countByExample(PersonTableExample example) {

		return personTableMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PersonTableExample example) {

		return personTableMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String personNum) {

		return personTableMapper.deleteByPrimaryKey(personNum);
	}

	@Override
	public int insert(PersonTable record) {

		return personTableMapper.insert(record);
	}

	@Override
	public int insertSelective(PersonTable record) {

		return personTableMapper.insertSelective(record);
	}

	@Override
	public List<PersonTable> selectByExample(PersonTableExample example) {

		return personTableMapper.selectByExample(example);
	}

	@Override
	public PersonTable selectByPrimaryKey(String personNum) {

		return personTableMapper.selectByPrimaryKey(personNum);
	}

	@Override
	public int updateByExampleSelective(PersonTable record, PersonTableExample example) {

		return personTableMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(PersonTable record, PersonTableExample example) {

		return personTableMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(PersonTable record) {

		return personTableMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PersonTable record) {

		return personTableMapper.updateByPrimaryKey(record);
	}

}
