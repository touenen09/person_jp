package com.mitsubishi.demo.functions.personjobhistory.facade;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableKey;

public interface PersonJobHistoryFacade {

	List<PersonJobHistoryTable> selectByExample();

	List<PersonJobHistoryTable> selectByExample(PersonJobHistoryTableExample example);

	int insertSelective(PersonJobHistoryTable record);

	PersonJobHistoryTable selectByPrimaryKey(PersonJobHistoryTableKey key);

	int updateByPrimaryKey(PersonJobHistoryTable record);

	int deleteByPrimaryKey(PersonJobHistoryTableKey key);
}
