package com.mitsubishi.demo.functions.personcareer.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.dataset.PersonCareerDataExample;
import com.mitsubishi.demo.common.service.PersonCareerDataService;
import com.mitsubishi.demo.functions.personcareer.facade.PersonCareerFacade;

@Service
@Transactional
public class PersonCareerFacadeImpl implements PersonCareerFacade {

	@Autowired
	PersonCareerDataService personCareerDataService;

	@Override
	public List<PersonCareerData> selectByExample(PersonCareerDataExample example) {

		return personCareerDataService.selectByExample(example);
	}

}
