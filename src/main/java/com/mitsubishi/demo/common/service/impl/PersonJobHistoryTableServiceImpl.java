package com.mitsubishi.demo.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableKey;
import com.mitsubishi.demo.common.mapper.PersonJobHistoryTableMapper;
import com.mitsubishi.demo.common.service.PersonJobHistoryTableService;

@Service
public class PersonJobHistoryTableServiceImpl implements PersonJobHistoryTableService {

	@Autowired
	PersonJobHistoryTableMapper personJobHistoryTableMapper;

	@Override
	public long countByExample(PersonJobHistoryTableExample example) {

		return 0;
	}

	@Override
	public int deleteByExample(PersonJobHistoryTableExample example) {

		return 0;
	}

	@Override
	public int deleteByPrimaryKey(PersonJobHistoryTableKey key) {

		return 0;
	}

	@Override
	public int insert(PersonJobHistoryTable record) {

		return 0;
	}

	@Override
	public int insertSelective(PersonJobHistoryTable record) {

		return 0;
	}

	@Override
	public List<PersonJobHistoryTable> selectByExample(PersonJobHistoryTableExample example) {

		return personJobHistoryTableMapper.selectByExample(example);
	}

	@Override
	public PersonJobHistoryTable selectByPrimaryKey(PersonJobHistoryTableKey key) {

		return null;
	}

	@Override
	public int updateByExampleSelective(PersonJobHistoryTable record, PersonJobHistoryTableExample example) {

		return 0;
	}

	@Override
	public int updateByExample(PersonJobHistoryTable record, PersonJobHistoryTableExample example) {

		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PersonJobHistoryTable record) {

		return 0;
	}

	@Override
	public int updateByPrimaryKey(PersonJobHistoryTable record) {

		return 0;
	}

}
