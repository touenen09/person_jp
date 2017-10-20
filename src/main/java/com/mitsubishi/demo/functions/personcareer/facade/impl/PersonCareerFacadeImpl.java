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
				insertCount += insertPersonCareerDataAll(personCareerDataExt);
			}

			// 主務歴史ヘッダと詳細リスト,0:ヘッダ,1:詳細
			List<PersonCareerDataHistory> personCareerDataSyumuHistoryList = form.getPersonCareerDataSyumuHistoryList();

			if (personCareerDataSyumuHistoryList != null) {
				for (PersonCareerDataHistory personCareerDataHistory : personCareerDataSyumuHistoryList) {
					List<PersonCareerDataExt> personCareerDataExtHistoryList = personCareerDataHistory
							.getPersonCareerDataExtHistoryList();
					for (PersonCareerDataExt personCareerDataExt : personCareerDataExtHistoryList) {
						insertCount += insertPersonCareerDataAll(personCareerDataExt);
					}
				}
			}

			// 兼務詳細リスト
			List<PersonCareerDataExt> personCareerDataKenmuDetailList = form.getPersonCareerDataKenmuDetailList();

			if (personCareerDataKenmuDetailList != null) {
				for (PersonCareerDataExt personCareerDataExt : personCareerDataKenmuDetailList) {
					insertCount += insertPersonCareerDataAll(personCareerDataExt);
				}
			}

		} catch (Exception e) {
			throw e;
		}

		return insertCount;
	}

	private int insertPersonCareerDataAll(PersonCareerDataExt personCareerDataExt) throws ParseException {

		int i = 0;

		String personNum = personCareerDataExt.getPersonNum();

		// 特別処理
		if (personNum.contains(",")) {
			String[] personNumArray = personNum.split(",");
			String[] startDateStringArray = personCareerDataExt.getStartDateString().split(",");
			String[] endDateStringArray = null;
			if (personCareerDataExt.getEndDateString() != null && !"".equals(personCareerDataExt.getEndDateString())) {
				endDateStringArray = personCareerDataExt.getEndDateString().split(",");
			}

			String[] productArray = personCareerDataExt.getProduct().split(",");
			String[] productDetailArray = personCareerDataExt.getProductDetail().split(",");
			String[] functionArray = personCareerDataExt.getFunction().split(",");
			String[] functionDetailArray = personCareerDataExt.getFunctionDetail().split(",");
			String[] locationArray = personCareerDataExt.getLocation().split(",");

			for (int j = 0; j < locationArray.length; j++) {

				PersonCareerDataExt tmpPersonCareerDataExt = new PersonCareerDataExt();
				tmpPersonCareerDataExt.setPersonNum(personNumArray[j]);
				tmpPersonCareerDataExt.setStartDateString(startDateStringArray[j]);

				if (endDateStringArray != null) {
					tmpPersonCareerDataExt.setEndDateString(endDateStringArray[j]);
				}

				tmpPersonCareerDataExt.setProduct(productArray[j]);
				tmpPersonCareerDataExt.setProductDetail(productDetailArray[j]);
				tmpPersonCareerDataExt.setFunction(functionArray[j]);
				tmpPersonCareerDataExt.setFunctionDetail(functionDetailArray[j]);
				tmpPersonCareerDataExt.setLocation(locationArray[j]);
				i += insertPersonCareerData(tmpPersonCareerDataExt);
			}

		} else {
			i += insertPersonCareerData(personCareerDataExt);
		}

		return i;
	}

	private int insertPersonCareerData(PersonCareerDataExt personCareerDataExt) throws ParseException {

		int i = 0;

		if (personCareerDataExt.getStartDateString() != null && !"".equals(personCareerDataExt.getStartDateString())) {

			personCareerDataExt.setStartDate(DateUtil.convertStringToDate(personCareerDataExt.getStartDateString(),
					DateUtil.DATE_PATTERN_DATE_MOL));
			if (personCareerDataExt.getEndDateString() != null && !"".equals(personCareerDataExt.getEndDateString())) {
				personCareerDataExt.setEndDate(DateUtil.convertStringToDate(personCareerDataExt.getEndDateString(),
						DateUtil.DATE_PATTERN_DATE_MOL));
			}

			PersonCareerData personCareerData = new PersonCareerData();
			BeanUtils.copyProperties(personCareerDataExt, personCareerData);

			// TODO
			personCareerData.setEffectiveDate(DateUtil.removeTime(personCareerData.getEffectiveDate()));
			personCareerData.setAddUpdateDatetime(new Date());
			personCareerData.setUserId("Admin");
			i += personCareerDataService.insert(personCareerData);
		}

		return i;
	}

}
