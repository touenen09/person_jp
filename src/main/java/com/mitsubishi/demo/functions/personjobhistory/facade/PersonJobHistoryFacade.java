package com.mitsubishi.demo.functions.personjobhistory.facade;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample;

public interface PersonJobHistoryFacade {

	List<PersonJobHistoryTable> selectByExample();

	List<PersonJobHistoryTable> selectByExample(PersonJobHistoryTableExample example);
}
