package com.mitsubishi.demo.functions.personcareer.facade;

import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.dataset.PersonCareerDataExample;

public interface PersonCareerFacade {

	List<PersonCareerData> selectByExample(PersonCareerDataExample example);
}
