package com.mitsubishi.demo.functions.personcareer.facade;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonTable;
import com.mitsubishi.demo.common.dataset.PersonTableExample;

public interface PersonCareerFacade {

	List<PersonTable> selectByExample();

	List<PersonTable> selectByExample(PersonTableExample example);

	int insertSelective(PersonTable record);

	PersonTable selectByPrimaryKey(String personNum);

	int updateByPrimaryKey(PersonTable record);

	int deleteByPrimaryKey(String personNum);
}
