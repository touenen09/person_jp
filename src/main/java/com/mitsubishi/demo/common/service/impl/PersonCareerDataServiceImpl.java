package com.mitsubishi.demo.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.dataset.PersonCareerDataExample;
import com.mitsubishi.demo.common.dataset.PersonCareerDataKey;
import com.mitsubishi.demo.common.mapper.PersonCareerDataMapper;
import com.mitsubishi.demo.common.service.PersonCareerDataService;

@Service
public class PersonCareerDataServiceImpl implements PersonCareerDataService {

	@Autowired
	PersonCareerDataMapper personCareerDataMapper;

	@Override
	public long countByExample(PersonCareerDataExample example) {

		return 0;
	}

	@Override
	public int deleteByExample(PersonCareerDataExample example) {

		return 0;
	}

	@Override
	public int deleteByPrimaryKey(PersonCareerDataKey key) {

		return 0;
	}

	@Override
	public int insert(PersonCareerData record) {

		return 0;
	}

	@Override
	public int insertSelective(PersonCareerData record) {

		return 0;
	}

	@Override
	public List<PersonCareerData> selectByExample(PersonCareerDataExample example) {

		return personCareerDataMapper.selectByExample(example);
	}

	@Override
	public PersonCareerData selectByPrimaryKey(PersonCareerDataKey key) {

		return null;
	}

	@Override
	public int updateByExampleSelective(PersonCareerData record, PersonCareerDataExample example) {

		return 0;
	}

	@Override
	public int updateByExample(PersonCareerData record, PersonCareerDataExample example) {

		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(PersonCareerData record) {

		return 0;
	}

	@Override
	public int updateByPrimaryKey(PersonCareerData record) {

		return 0;
	}

}
