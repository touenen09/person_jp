package com.mitsubishi.demo.functions.personcareer.facade.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.dataset.PersonCareerDataExample;
import com.mitsubishi.demo.common.service.PersonCareerDataService;
import com.mitsubishi.demo.common.util.DateUtil;
import com.mitsubishi.demo.functions.personcareer.facade.PersonCareerFacade;
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerDataExt;
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerForm;

@Service
@Transactional
public class PersonCareerFacadeImpl implements PersonCareerFacade {

	@Autowired
	PersonCareerDataService personCareerDataService;

	@Override
	public List<PersonCareerData> selectByExample(PersonCareerDataExample example) {

		return personCareerDataService.selectByExample(example);
	}

	@Override
	public int updatePersonCareerData(PersonCareerForm form) throws ParseException {

		int insertCount = 0;

		try {

			String personNum = form.getPersonTableForm().getPersonNum();

			// 削除処理
			PersonCareerDataExample personCareerDataExample = new PersonCareerDataExample();
			personCareerDataService.deleteByExample(personCareerDataExample);

			// 主務詳細リスト
			List<PersonCareerDataExt> personCareerDataSyumuDetailList = form.getPersonCareerDataSyumuDetailList();

			for (PersonCareerDataExt personCareerDataExt : personCareerDataSyumuDetailList) {
				personCareerDataExt.setPersonNum(personNum);
				insertCount += insertPersonCareerData(personCareerDataExt);
			}

			// 主務歴史ヘッダと詳細リスト,0:ヘッダ,1:詳細
			List<Object[]> personCareerDataSyumuHistoryList = form.getPersonCareerDataSyumuHistoryList();

			for (Object[] objects : personCareerDataSyumuHistoryList) {
				List<PersonCareerDataExt> tmpList = (List<PersonCareerDataExt>) objects[1];
				for (PersonCareerDataExt personCareerDataExt : tmpList) {
					personCareerDataExt.setPersonNum(personNum);
					insertCount += insertPersonCareerData(personCareerDataExt);
				}
			}

			// 兼務詳細リスト
			List<PersonCareerDataExt> personCareerDataKenmuDetailList = form.getPersonCareerDataKenmuDetailList();

			for (PersonCareerDataExt personCareerDataExt : personCareerDataKenmuDetailList) {
				personCareerDataExt.setPersonNum(personNum);
				insertCount += insertPersonCareerData(personCareerDataExt);
			}
		} catch (Exception e) {
			throw e;
		}

		return insertCount;
	}

	private int insertPersonCareerData(PersonCareerDataExt personCareerDataExt) throws ParseException {

		personCareerDataExt.setStartDate(DateUtil.convertStringToDate(personCareerDataExt.getStartDateString(),
				DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));
		personCareerDataExt.setEndDate(DateUtil.convertStringToDate(personCareerDataExt.getEndDateString(),
				DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));

		PersonCareerData personCareerData = new PersonCareerData();
		BeanUtils.copyProperties(personCareerDataExt, personCareerData);

		// TODO
		personCareerData.setAddUpdateDatetime(new Date());
		personCareerData.setUserId("Admin");

		int i = personCareerDataService.insert(personCareerData);

		return i;
	}

}
