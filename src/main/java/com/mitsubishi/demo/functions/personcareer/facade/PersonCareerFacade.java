package com.mitsubishi.demo.functions.personcareer.facade;

import java.text.ParseException;
import java.util.List;

import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.dataset.PersonCareerDataExample;
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerForm;

public interface PersonCareerFacade {

	List<PersonCareerData> selectByExample(PersonCareerDataExample example);

	int updatePersonCareerData(PersonCareerForm form) throws ParseException;
}
