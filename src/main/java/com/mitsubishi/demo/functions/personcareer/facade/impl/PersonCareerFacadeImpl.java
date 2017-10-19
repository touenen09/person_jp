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
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerDataHistory;
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
			com.mitsubishi.demo.common.dataset.PersonCareerDataExample.Criteria personCareerDataExampleCriteria = personCareerDataExample
					.createCriteria();
			personCareerDataExampleCriteria.andPersonNumEqualTo(personNum);
			personCareerDataService.deleteByExample(personCareerDataExample);

			// 主務詳細リスト
			List<PersonCareerDataExt> personCareerDataSyumuDetailList = form.getPersonCareerDataSyumuDetailList();

			for (PersonCareerDataExt personCareerDataExt : personCareerDataSyumuDetailList) {
				insertCount += insertPersonCareerData(personCareerDataExt);
			}

			// 主務歴史ヘッダと詳細リスト,0:ヘッダ,1:詳細
			List<PersonCareerDataHistory> personCareerDataSyumuHistoryList = form.getPersonCareerDataSyumuHistoryList();

			if (personCareerDataSyumuHistoryList != null) {
				for (PersonCareerDataHistory personCareerDataHistory : personCareerDataSyumuHistoryList) {
					List<PersonCareerDataExt> personCareerDataExtHistoryList = personCareerDataHistory
							.getPersonCareerDataExtHistoryList();
					for (PersonCareerDataExt personCareerDataExt : personCareerDataExtHistoryList) {
						insertCount += insertPersonCareerData(personCareerDataExt);
					}
				}
			}

			// 兼務詳細リスト
			List<PersonCareerDataExt> personCareerDataKenmuDetailList = form.getPersonCareerDataKenmuDetailList();

			if (personCareerDataKenmuDetailList != null) {
				for (PersonCareerDataExt personCareerDataExt : personCareerDataKenmuDetailList) {
					insertCount += insertPersonCareerData(personCareerDataExt);
				}
			}

		} catch (Exception e) {
			throw e;
		}

		return insertCount;
	}

	private int insertPersonCareerData(PersonCareerDataExt personCareerDataExt) throws ParseException {

		int i = 0;

		if (personCareerDataExt.getStartDateString() != null && personCareerDataExt.getEndDateString() != null) {
			personCareerDataExt.setStartDate(DateUtil.convertStringToDate(personCareerDataExt.getStartDateString(),
					DateUtil.DATE_PATTERN_DATE_MOL));
			personCareerDataExt.setEndDate(DateUtil.convertStringToDate(personCareerDataExt.getEndDateString(),
					DateUtil.DATE_PATTERN_DATE_MOL));

			PersonCareerData personCareerData = new PersonCareerData();
			BeanUtils.copyProperties(personCareerDataExt, personCareerData);

			// TODO
			personCareerData.setEffectiveDate(DateUtil.removeTime(personCareerData.getEffectiveDate()));
			personCareerData.setAddUpdateDatetime(new Date());
			personCareerData.setUserId("Admin");

			i = personCareerDataService.insert(personCareerData);
		}

		return i;
	}

}
