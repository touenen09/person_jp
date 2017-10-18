package com.mitsubishi.demo.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.InformationTable;
import com.mitsubishi.demo.common.dataset.InformationTableExample;
import com.mitsubishi.demo.common.dataset.InformationTableKey;
import com.mitsubishi.demo.common.mapper.InformationTableMapper;
import com.mitsubishi.demo.common.service.InformationTableService;

@Service
public class InformationTableServiceImpl implements InformationTableService {

	@Autowired
	InformationTableMapper informationTableMapper;

	@Override
	public long countByExample(InformationTableExample example) {

		return 0;
	}

	@Override
	public int deleteByExample(InformationTableExample example) {

		return 0;
	}

	@Override
	public int deleteByPrimaryKey(InformationTableKey key) {

		return 0;
	}

	@Override
	public int insert(InformationTable record) {

		return 0;
	}

	@Override
	public int insertSelective(InformationTable record) {

		return 0;
	}

	@Override
	public List<InformationTable> selectByExample(InformationTableExample example) {

		return informationTableMapper.selectByExample(example);
	}

	@Override
	public InformationTable selectByPrimaryKey(InformationTableKey key) {

		return informationTableMapper.selectByPrimaryKey(key);
	}

	@Override
	public int updateByExampleSelective(InformationTable record, InformationTableExample example) {

		return 0;
	}

	@Override
	public int updateByExample(InformationTable record, InformationTableExample example) {

		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(InformationTable record) {

		return 0;
	}

	@Override
	public int updateByPrimaryKey(InformationTable record) {

		return 0;
	}

}
