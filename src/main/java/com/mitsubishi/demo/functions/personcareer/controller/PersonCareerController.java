package com.mitsubishi.demo.functions.personcareer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitsubishi.demo.common.constant.ComConst;
import com.mitsubishi.demo.common.dataset.InformationTable;
import com.mitsubishi.demo.common.dataset.InformationTableExample;
import com.mitsubishi.demo.common.dataset.PersonCareerData;
import com.mitsubishi.demo.common.dataset.PersonCareerDataExample;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample;
import com.mitsubishi.demo.common.dataset.PersonTable;
import com.mitsubishi.demo.common.entity.ListInfo;
import com.mitsubishi.demo.common.util.CssUtil;
import com.mitsubishi.demo.common.util.DateUtil;
import com.mitsubishi.demo.functions.person.facade.PersonFacade;
import com.mitsubishi.demo.functions.person.form.PersonTableForm;
import com.mitsubishi.demo.functions.personcareer.facade.InformationFacade;
import com.mitsubishi.demo.functions.personcareer.facade.PersonCareerFacade;
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerDataExt;
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerForm;
import com.mitsubishi.demo.functions.personjobhistory.facade.PersonJobHistoryFacade;

@Controller
@RequestMapping("/authorization/personcareer")
public class PersonCareerController {

	@Autowired
	PersonFacade personFacade;

	@Autowired
	PersonJobHistoryFacade personJobHistoryFacade;

	@Autowired
	PersonCareerFacade personCareerFacade;

	@Autowired
	InformationFacade informationFacade;

	@ModelAttribute
	public PersonTableForm getPersonTableForm() {
		return new PersonTableForm();
	}

	@ModelAttribute
	public PersonCareerForm getPersonCareerForm() {
		return new PersonCareerForm();
	}

	@RequestMapping("/goIndex/{confId}")
	public String goIndex(@PathVariable("confId") String confId, Model model) {

		/*
		 * if ("1".equals(confId)) { return "/authorization/personcareer/list"; }
		 */

		List<PersonTable> personList = personFacade.selectByExample();
		model.addAttribute("page", personList);

		return "authorization/personcareer/list";
	}

	@RequestMapping("/goRegist/{personNum}")
	public String goRegist(PersonCareerForm form, @PathVariable("personNum") String personNum, Model model) {

		CssUtil.setButtonCss(model, ComConst.C_REGIST);

		// 従業員情報
		PersonTable personTable = personFacade.selectByPrimaryKey(personNum);
		PersonTableForm personTableForm = new PersonTableForm();
		BeanUtils.copyProperties(personTable, personTableForm);
		form.setPersonTableForm(personTableForm);

		// 従業員主務ヘッダ情報
		PersonJobHistoryTableExample personJobHistoryTableExample = new PersonJobHistoryTableExample();
		com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample.Criteria personJobHistoryTableExampleCriteria = personJobHistoryTableExample
				.createCriteria();
		personJobHistoryTableExampleCriteria.andPersonNumEqualTo(personNum);
		personJobHistoryTableExampleCriteria.andAppointmentEqualTo("01"); // 主務
		personJobHistoryTableExample.setOrderByClause("EFFECTIVE_DATE desc"); // 降順
		List<PersonJobHistoryTable> personJobHistoryTableList = personJobHistoryFacade
				.selectByExample(personJobHistoryTableExample);

		if (personJobHistoryTableList != null && personJobHistoryTableList.size() > 0) {

			// 従業員主務ヘッダ情報セット
			PersonJobHistoryTable personJobHistoryTable = personJobHistoryTableList.get(0);
			form.setPersonCareerDataSyumuHeader(personJobHistoryTable);

			// 従業員主務詳細情報セット
			PersonCareerDataExample personCareerDataExample = new PersonCareerDataExample();
			com.mitsubishi.demo.common.dataset.PersonCareerDataExample.Criteria personCareerDataExampleCriteria = personCareerDataExample
					.createCriteria();
			personCareerDataExampleCriteria.andPersonNumEqualTo(personNum);
			personCareerDataExampleCriteria.andAppointmentEqualTo(personJobHistoryTable.getAppointment());
			personCareerDataExampleCriteria.andEffectiveDateEqualTo(personJobHistoryTable.getEffectiveDate());
			personJobHistoryTableExample.setOrderByClause("START_DATE desc"); // 降順
			List<PersonCareerData> personCareerDataList = personCareerFacade.selectByExample(personCareerDataExample);

			//
			List<PersonCareerDataExt> personCareerDataExtList = new ArrayList<PersonCareerDataExt>();
			for (PersonCareerData personCareerData : personCareerDataList) {
				PersonCareerDataExt personCareerDataExt = new PersonCareerDataExt();

				BeanUtils.copyProperties(personCareerData, personCareerDataExt);
				personCareerDataExt.setStartDateString(DateUtil.convertDateToString(personCareerDataExt.getStartDate(),
						DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));
				personCareerDataExt.setEndDateString(DateUtil.convertDateToString(personCareerDataExt.getEndDate(),
						DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));

				/**
				 * select list
				 */
				List<ListInfo> seleteProduct = new ArrayList<ListInfo>();
				List<ListInfo> seleteProductDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunction = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunctionDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteLocation = new ArrayList<ListInfo>();

				if ("1".equals(personJobHistoryTable.getGroup1())) {

					seleteProduct.addAll(getListInfo("Product1", personCareerDataExt.getProduct(), null));
					seleteProductDetail.addAll(getListInfo("Product1", personCareerDataExt.getProduct(), null));
					seleteFunction.addAll(getListInfo("Function1", personCareerDataExt.getFunction(), null));
					seleteFunctionDetail.addAll(getListInfo("Function1", personCareerDataExt.getFunction(),
							personCareerDataExt.getFunctionDetail()));
					seleteLocation.addAll(getListInfo("Location", personCareerDataExt.getLocation(), null));
				} else {

					seleteProduct.addAll(getListInfo("Product2", personCareerDataExt.getProduct(), null));
					seleteProductDetail.addAll(getListInfo("Product2", personCareerDataExt.getProduct(),
							personCareerDataExt.getProductDetail()));
					seleteFunction.addAll(getListInfo("Function2", personCareerDataExt.getFunction(), null));
					seleteFunctionDetail.addAll(getListInfo("Function2", personCareerDataExt.getFunction(),
							personCareerDataExt.getFunctionDetail()));
				}

				seleteLocation.addAll(getListInfo("Location", personCareerDataExt.getLocation(), null));

				personCareerDataExt.setSeleteProduct(seleteProduct);
				personCareerDataExt.setSeleteProductDetail(seleteProductDetail);
				personCareerDataExt.setSeleteFunction(seleteFunction);
				personCareerDataExt.setSeleteFunctionDetail(seleteFunctionDetail);
				personCareerDataExt.setSeleteLocation(seleteLocation);

				personCareerDataExtList.add(personCareerDataExt);
			}

			form.setPersonCareerDataSyumuDetailList(personCareerDataExtList);

			// 最新の主務を外す
			personJobHistoryTableList.remove(0);
		}

		// 従業員主務歴史情報
		if (personJobHistoryTableList != null && personJobHistoryTableList.size() > 0) {

			List<Object[]> personCareerDataSyumuHistoryList = new ArrayList<Object[]>();

			for (PersonJobHistoryTable personJobHistoryTable : personJobHistoryTableList) {
				// 従業員主務ヘッダ情報セット
				Object[] obj = new Object[2];
				obj[0] = personJobHistoryTable;
				// form.setPersonCareerDataSyumuHeader(personJobHistoryTable);

				// 従業員主務詳細情報セット
				PersonCareerDataExample personCareerDataExample = new PersonCareerDataExample();
				com.mitsubishi.demo.common.dataset.PersonCareerDataExample.Criteria personCareerDataExampleCriteria = personCareerDataExample
						.createCriteria();
				personCareerDataExampleCriteria.andPersonNumEqualTo(personNum);
				personCareerDataExampleCriteria.andAppointmentEqualTo(personJobHistoryTable.getAppointment());
				personCareerDataExampleCriteria.andEffectiveDateEqualTo(personJobHistoryTable.getEffectiveDate());
				personJobHistoryTableExample.setOrderByClause("START_DATE desc"); // 降順
				List<PersonCareerData> personCareerDataList = personCareerFacade
						.selectByExample(personCareerDataExample);

				//
				List<PersonCareerDataExt> personCareerDataExtList = new ArrayList<PersonCareerDataExt>();
				for (PersonCareerData personCareerData : personCareerDataList) {
					PersonCareerDataExt personCareerDataExt = new PersonCareerDataExt();

					BeanUtils.copyProperties(personCareerData, personCareerDataExt);
					personCareerDataExt.setStartDateString(DateUtil.convertDateToString(
							personCareerDataExt.getStartDate(), DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));
					personCareerDataExt.setEndDateString(DateUtil.convertDateToString(personCareerDataExt.getEndDate(),
							DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));

					/**
					 * select list
					 */
					List<ListInfo> seleteProduct = new ArrayList<ListInfo>();
					List<ListInfo> seleteProductDetail = new ArrayList<ListInfo>();
					List<ListInfo> seleteFunction = new ArrayList<ListInfo>();
					List<ListInfo> seleteFunctionDetail = new ArrayList<ListInfo>();
					List<ListInfo> seleteLocation = new ArrayList<ListInfo>();

					if ("1".equals(personJobHistoryTable.getGroup1())) {

						seleteProduct.addAll(getListInfo("Product1", personCareerDataExt.getProduct(), null));
						seleteProductDetail.addAll(getListInfo("Product1", personCareerDataExt.getProduct(), null));
						seleteFunction.addAll(getListInfo("Function1", personCareerDataExt.getFunction(), null));
						seleteFunctionDetail.addAll(getListInfo("Function1", personCareerDataExt.getFunction(),
								personCareerDataExt.getFunctionDetail()));
						seleteLocation.addAll(getListInfo("Location", personCareerDataExt.getLocation(), null));
					} else {

						seleteProduct.addAll(getListInfo("Product2", personCareerDataExt.getProduct(), null));
						seleteProductDetail.addAll(getListInfo("Product2", personCareerDataExt.getProduct(),
								personCareerDataExt.getProductDetail()));
						seleteFunction.addAll(getListInfo("Function2", personCareerDataExt.getFunction(), null));
						seleteFunctionDetail.addAll(getListInfo("Function2", personCareerDataExt.getFunction(),
								personCareerDataExt.getFunctionDetail()));
					}

					seleteLocation.addAll(getListInfo("Location", personCareerDataExt.getLocation(), null));

					personCareerDataExt.setSeleteProduct(seleteProduct);
					personCareerDataExt.setSeleteProductDetail(seleteProductDetail);
					personCareerDataExt.setSeleteFunction(seleteFunction);
					personCareerDataExt.setSeleteFunctionDetail(seleteFunctionDetail);
					personCareerDataExt.setSeleteLocation(seleteLocation);

					personCareerDataExtList.add(personCareerDataExt);
				}

				obj[1] = personCareerDataExtList;
				personCareerDataSyumuHistoryList.add(obj);

			}

			form.setPersonCareerDataSyumuHistoryList(personCareerDataSyumuHistoryList);
		}

		//
		// 従業員主務ヘッダ情報
		PersonJobHistoryTableExample personJobHistoryTableExampleKenmu = new PersonJobHistoryTableExample();
		com.mitsubishi.demo.common.dataset.PersonJobHistoryTableExample.Criteria personJobHistoryTableExampleKenmuCriteria = personJobHistoryTableExampleKenmu
				.createCriteria();
		personJobHistoryTableExampleKenmuCriteria.andPersonNumEqualTo(personNum);
		personJobHistoryTableExampleKenmuCriteria.andAppointmentEqualTo("02"); // 主務
		personJobHistoryTableExampleKenmu.setOrderByClause("EFFECTIVE_DATE desc"); // 降順
		List<PersonJobHistoryTable> personJobHistoryTableKenmuList = personJobHistoryFacade
				.selectByExample(personJobHistoryTableExampleKenmu);

		if (personJobHistoryTableKenmuList != null && personJobHistoryTableKenmuList.size() > 0) {

			// 従業員兼務ヘッダ情報セット
			PersonJobHistoryTable personJobHistoryTableKenmu = personJobHistoryTableKenmuList.get(0);
			form.setPersonCareerDataKenmuHeader(personJobHistoryTableKenmu);

			// 従業員兼務詳細情報セット
			PersonCareerDataExample personCareerDataExampleKenmu = new PersonCareerDataExample();
			com.mitsubishi.demo.common.dataset.PersonCareerDataExample.Criteria personCareerDataExampleKenmuCriteria = personCareerDataExampleKenmu
					.createCriteria();
			personCareerDataExampleKenmuCriteria.andPersonNumEqualTo(personNum);
			personCareerDataExampleKenmuCriteria.andAppointmentEqualTo(personJobHistoryTableKenmu.getAppointment());
			personCareerDataExampleKenmuCriteria.andEffectiveDateEqualTo(personJobHistoryTableKenmu.getEffectiveDate());
			personCareerDataExampleKenmu.setOrderByClause("START_DATE desc"); // 降順
			List<PersonCareerData> personCareerDataKenmuList = personCareerFacade
					.selectByExample(personCareerDataExampleKenmu);

			//
			List<PersonCareerDataExt> personCareerDataExtKenmuList = new ArrayList<PersonCareerDataExt>();
			for (PersonCareerData personCareerData : personCareerDataKenmuList) {
				PersonCareerDataExt personCareerDataExt = new PersonCareerDataExt();

				BeanUtils.copyProperties(personCareerData, personCareerDataExt);
				personCareerDataExt.setStartDateString(DateUtil.convertDateToString(personCareerDataExt.getStartDate(),
						DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));
				personCareerDataExt.setEndDateString(DateUtil.convertDateToString(personCareerDataExt.getEndDate(),
						DateUtil.DATE_PATTERN_YEAR_MONTH_MOL));

				/**
				 * select list
				 */
				List<ListInfo> seleteProduct = new ArrayList<ListInfo>();
				List<ListInfo> seleteProductDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunction = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunctionDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteLocation = new ArrayList<ListInfo>();

				if ("1".equals(personJobHistoryTableKenmu.getGroup1())) {

					seleteProduct.addAll(getListInfo("Product1", personCareerDataExt.getProduct(), null));
					seleteProductDetail.addAll(getListInfo("Product1", personCareerDataExt.getProduct(), null));
					seleteFunction.addAll(getListInfo("Function1", personCareerDataExt.getFunction(), null));
					seleteFunctionDetail.addAll(getListInfo("Function1", personCareerDataExt.getFunction(),
							personCareerDataExt.getFunctionDetail()));
					seleteLocation.addAll(getListInfo("Location", personCareerDataExt.getLocation(), null));
				} else {

					seleteProduct.addAll(getListInfo("Product2", personCareerDataExt.getProduct(), null));
					seleteProductDetail.addAll(getListInfo("Product2", personCareerDataExt.getProduct(),
							personCareerDataExt.getProductDetail()));
					seleteFunction.addAll(getListInfo("Function2", personCareerDataExt.getFunction(), null));
					seleteFunctionDetail.addAll(getListInfo("Function2", personCareerDataExt.getFunction(),
							personCareerDataExt.getFunctionDetail()));
				}

				seleteLocation.addAll(getListInfo("Location", personCareerDataExt.getLocation(), null));

				personCareerDataExt.setSeleteProduct(seleteProduct);
				personCareerDataExt.setSeleteProductDetail(seleteProductDetail);
				personCareerDataExt.setSeleteFunction(seleteFunction);
				personCareerDataExt.setSeleteFunctionDetail(seleteFunctionDetail);
				personCareerDataExt.setSeleteLocation(seleteLocation);

				personCareerDataExtKenmuList.add(personCareerDataExt);

			}

			form.setPersonCareerDataKenmuDetailList(personCareerDataExtKenmuList);

			// 最新の主務を外す
			personJobHistoryTableKenmuList.remove(0);
		}

		return "authorization/personcareer/detail";
	}

	private List<ListInfo> getListInfo(String key1, String key2, String key3) {

		List<ListInfo> listInfo = new ArrayList<ListInfo>();

		InformationTableExample informationTableExample = new InformationTableExample();
		com.mitsubishi.demo.common.dataset.InformationTableExample.Criteria informationTableExampleCriteria = informationTableExample
				.createCriteria();

		informationTableExampleCriteria.andKey1EqualTo(key1);
		informationTableExampleCriteria.andKey2EqualTo(key2);
		if (key3 != null) {
			informationTableExampleCriteria.andKey2EqualTo(key3);
		}

		List<InformationTable> informationTableList = informationFacade.selectByExample(informationTableExample);

		for (InformationTable informationTable : informationTableList) {
			ListInfo info = new ListInfo();
			info.setCode(informationTable.getKey2());
			info.setName(informationTable.getValueLong());
			listInfo.add(info);
		}

		return listInfo;
	}

	@RequestMapping("/doRegist")
	public String doRegist(PersonCareerForm form, BindingResult result, Model model) {

		List<PersonCareerDataExt> personCareerDataSyumuDetailList = form.getPersonCareerDataSyumuDetailList();
		if (personCareerDataSyumuDetailList != null && personCareerDataSyumuDetailList.size() > 0) {
			for (PersonCareerDataExt personCareerDataExt : personCareerDataSyumuDetailList) {
				System.out.println(personCareerDataExt.getStartDate());
			}
		}

		// List<PersonCareerDataExt> list2 = form.getPersonCareerDataSyumuHistoryList();
		// List<PersonCareerDataExt> list3 = form.getPersonCareerDataKenmuDetailList();

		return "redirect:/authorization/personcareer/goIndex/1";
	}

	@RequestMapping("/goUpdate/{personNum}")
	public String goUpdate(PersonTableForm form, @PathVariable("personNum") String personNum, Model model) {

		CssUtil.setButtonCss(model, ComConst.C_UPDATE);

		PersonTable personTable = personFacade.selectByPrimaryKey(personNum);
		BeanUtils.copyProperties(personTable, form);

		return "authorization/personcareer/detail";
	}

	@RequestMapping("/doUpdate")
	public String doUpdate(PersonTableForm form, BindingResult result, Model model) {

		PersonTable personTable = new PersonTable();
		BeanUtils.copyProperties(form, personTable);
		personFacade.updateByPrimaryKey(personTable);
		return "redirect:/authorization/personcareer/goIndex/1";
	}

	@RequestMapping("/doDelete")
	public String doDelete(PersonTableForm form, BindingResult result, Model model) {

		String personNum = form.getPersonNum();
		personFacade.deleteByPrimaryKey(personNum);
		return "redirect:/authorization/personcareer/goIndex/1";
	}
}
