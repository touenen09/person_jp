package com.mitsubishi.demo.functions.personcareer.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitsubishi.demo.common.dataset.InformationTable;
import com.mitsubishi.demo.common.dataset.InformationTableExample;
import com.mitsubishi.demo.common.service.InformationTableService;
import com.mitsubishi.demo.functions.personcareer.facade.InformationFacade;

@Service
@Transactional
public class InformationFacadeImpl implements InformationFacade {

	@Autowired
	InformationTableService informationTableService;

	@Override
	public List<InformationTable> selectByExample(InformationTableExample example) {

		return informationTableService.selectByExample(example);
	}

}
