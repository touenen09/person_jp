package com.mitsubishi.demo.functions.personcareer.facade;

import java.util.List;

import com.mitsubishi.demo.common.dataset.InformationTable;
import com.mitsubishi.demo.common.dataset.InformationTableExample;

public interface InformationFacade {

	List<InformationTable> selectByExample(InformationTableExample example);

}