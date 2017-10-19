package com.mitsubishi.demo.functions.personcareer.controller;

import java.text.ParseException;
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
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerDataHistory;
import com.mitsubishi.demo.functions.personcareer.form.PersonCareerForm;
import com.mitsubishi.demo.functions.personcareer.form.PersonJobHistoryTableExt;
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

			// 異動区分と異動理由の名称を設定
			PersonJobHistoryTableExt personJobHistoryTableExt = new PersonJobHistoryTableExt();
			BeanUtils.copyProperties(personJobHistoryTable, personJobHistoryTableExt);
			personJobHistoryTableExt
					.setActionName(getInformationTableValue("Action", personJobHistoryTableExt.getAction(), "@NULL"));
			personJobHistoryTableExt.setActionReasonName(getInformationTableValue("Action",
					personJobHistoryTableExt.getAction(), personJobHistoryTableExt.getActionReason()));
			personJobHistoryTableExt.setLocationName(
					getInformationTableValue("Location", personJobHistoryTableExt.getLocation(), "@NULL"));

			form.setPersonCareerDataSyumuHeader(personJobHistoryTableExt);

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
						DateUtil.DATE_PATTERN_DATE_MOL));
				personCareerDataExt.setEndDateString(
						DateUtil.convertDateToString(personCareerDataExt.getEndDate(), DateUtil.DATE_PATTERN_DATE_MOL));

				/**
				 * select list
				 */
				List<ListInfo> seleteProduct = new ArrayList<ListInfo>();
				List<ListInfo> seleteProductDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunction = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunctionDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteLocation = new ArrayList<ListInfo>();

				if ("1".equals(personJobHistoryTable.getGroup1())) {

					seleteProduct.addAll(getListInfo("Product", "NULL", "@NULL"));
					seleteProductDetail.addAll(getListInfo("Product", personCareerDataExt.getProduct(), "NOTNULL"));
					seleteFunction.addAll(getListInfo("Function", "NULL", "@NULL"));
					seleteFunctionDetail.addAll(getListInfo("Function", personCareerDataExt.getFunction(), "NOTNULL"));
				} else {

					seleteProduct.addAll(getListInfo("Product", "NULL", "@NULL"));
					seleteProductDetail.addAll(getListInfo("Product", personCareerDataExt.getProduct(), "NOTNULL"));
					seleteFunction.addAll(getListInfo("Function", "NULL", "@NULL"));
					seleteFunctionDetail.addAll(getListInfo("Function", personCareerDataExt.getFunction(), "NOTNULL"));
				}

				seleteLocation.addAll(getListInfo("Location", "NULL", "@NULL"));

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

			List<PersonCareerDataHistory> personCareerDataSyumuHistoryList = new ArrayList<PersonCareerDataHistory>();

			for (PersonJobHistoryTable personJobHistoryTable : personJobHistoryTableList) {
				// 従業員主務ヘッダ情報セット
				PersonCareerDataHistory personCareerDataHistory = new PersonCareerDataHistory();

				// 異動区分と異動理由の名称を設定
				PersonJobHistoryTableExt personJobHistoryTableExt = new PersonJobHistoryTableExt();
				BeanUtils.copyProperties(personJobHistoryTable, personJobHistoryTableExt);
				personJobHistoryTableExt.setActionName(
						getInformationTableValue("Action", personJobHistoryTableExt.getAction(), "@NULL"));
				personJobHistoryTableExt.setActionReasonName(getInformationTableValue("Action",
						personJobHistoryTableExt.getAction(), personJobHistoryTableExt.getActionReason()));
				personJobHistoryTableExt.setLocationName(
						getInformationTableValue("Location", personJobHistoryTableExt.getLocation(), "@NULL"));

				form.setPersonCareerDataSyumuHeader(personJobHistoryTableExt);

				personCareerDataHistory.setPersonJobHistoryTableExt(personJobHistoryTableExt);

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
					personCareerDataExt.setStartDateString(DateUtil
							.convertDateToString(personCareerDataExt.getStartDate(), DateUtil.DATE_PATTERN_DATE_MOL));
					personCareerDataExt.setEndDateString(DateUtil.convertDateToString(personCareerDataExt.getEndDate(),
							DateUtil.DATE_PATTERN_DATE_MOL));

					/**
					 * select list
					 */
					List<ListInfo> seleteProduct = new ArrayList<ListInfo>();
					List<ListInfo> seleteProductDetail = new ArrayList<ListInfo>();
					List<ListInfo> seleteFunction = new ArrayList<ListInfo>();
					List<ListInfo> seleteFunctionDetail = new ArrayList<ListInfo>();
					List<ListInfo> seleteLocation = new ArrayList<ListInfo>();

					if ("1".equals(personJobHistoryTable.getGroup1())) {

						seleteProduct.addAll(getListInfo("Product", "NULL", "@NULL"));
						seleteProductDetail.addAll(getListInfo("Product", personCareerDataExt.getProduct(), "NOTNULL"));
						seleteFunction.addAll(getListInfo("Function", "NULL", "@NULL"));
						seleteFunctionDetail
								.addAll(getListInfo("Function", personCareerDataExt.getFunction(), "NOTNULL"));
					} else {

						seleteProduct.addAll(getListInfo("Product", "NULL", "@NULL"));
						seleteProductDetail.addAll(getListInfo("Product", personCareerDataExt.getProduct(), "NOTNULL"));
						seleteFunction.addAll(getListInfo("Function", "NULL", "@NULL"));
						seleteFunctionDetail
								.addAll(getListInfo("Function", personCareerDataExt.getFunction(), "NOTNULL"));
					}

					seleteLocation.addAll(getListInfo("Location", "NULL", "@NULL"));

					personCareerDataExt.setSeleteProduct(seleteProduct);
					personCareerDataExt.setSeleteProductDetail(seleteProductDetail);
					personCareerDataExt.setSeleteFunction(seleteFunction);
					personCareerDataExt.setSeleteFunctionDetail(seleteFunctionDetail);
					personCareerDataExt.setSeleteLocation(seleteLocation);

					personCareerDataExtList.add(personCareerDataExt);
				}

				personCareerDataHistory.setPersonCareerDataExtHistoryList(personCareerDataExtList);
				personCareerDataSyumuHistoryList.add(personCareerDataHistory);

			}

			form.setPersonCareerDataSyumuHistoryList(personCareerDataSyumuHistoryList);
		} else {
			List<PersonCareerDataHistory> personCareerDataSyumuHistoryList = new ArrayList<PersonCareerDataHistory>();
			PersonCareerDataHistory personCareerDataHistory = new PersonCareerDataHistory();
			List<PersonCareerDataExt> personCareerDataExtList = new ArrayList<PersonCareerDataExt>();
			PersonJobHistoryTableExt personJobHistoryTableExt = new PersonJobHistoryTableExt();
			personCareerDataHistory.setPersonJobHistoryTableExt(personJobHistoryTableExt);
			personCareerDataHistory.setPersonCareerDataExtHistoryList(personCareerDataExtList);
			personCareerDataSyumuHistoryList.add(personCareerDataHistory);

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

			// 異動区分と異動理由の名称を設定
			PersonJobHistoryTableExt personJobHistoryTableKenmuExt = new PersonJobHistoryTableExt();
			BeanUtils.copyProperties(personJobHistoryTableKenmu, personJobHistoryTableKenmuExt);
			personJobHistoryTableKenmuExt.setActionName(
					getInformationTableValue("Action", personJobHistoryTableKenmuExt.getAction(), "@NULL"));
			personJobHistoryTableKenmuExt.setActionReasonName(getInformationTableValue("Action",
					personJobHistoryTableKenmuExt.getAction(), personJobHistoryTableKenmuExt.getActionReason()));
			personJobHistoryTableKenmuExt.setLocationName(
					getInformationTableValue("Location", personJobHistoryTableKenmuExt.getLocation(), "@NULL"));

			form.setPersonCareerDataKenmuHeader(personJobHistoryTableKenmuExt);

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
						DateUtil.DATE_PATTERN_DATE_MOL));
				personCareerDataExt.setEndDateString(
						DateUtil.convertDateToString(personCareerDataExt.getEndDate(), DateUtil.DATE_PATTERN_DATE_MOL));

				/**
				 * select list
				 */
				List<ListInfo> seleteProduct = new ArrayList<ListInfo>();
				List<ListInfo> seleteProductDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunction = new ArrayList<ListInfo>();
				List<ListInfo> seleteFunctionDetail = new ArrayList<ListInfo>();
				List<ListInfo> seleteLocation = new ArrayList<ListInfo>();

				if ("1".equals(personJobHistoryTableKenmu.getGroup1())) {

					seleteProduct.addAll(getListInfo("Product", "NULL", "@NULL"));
					seleteProductDetail.addAll(getListInfo("Product", personCareerDataExt.getProduct(), "NOTNULL"));
					seleteFunction.addAll(getListInfo("Function", "NULL", "@NULL"));
					seleteFunctionDetail.addAll(getListInfo("Function", personCareerDataExt.getFunction(), "NOTNULL"));
				} else {

					seleteProduct.addAll(getListInfo("Product", "NULL", "@NULL"));
					seleteProductDetail.addAll(getListInfo("Product", personCareerDataExt.getProduct(), "NOTNULL"));
					seleteFunction.addAll(getListInfo("Function", "NULL", "@NULL"));
					seleteFunctionDetail.addAll(getListInfo("Function", personCareerDataExt.getFunction(), "NOTNULL"));
				}

				seleteLocation.addAll(getListInfo("Location", "NULL", "@NULL"));

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
		} else {
			List<PersonCareerDataExt> personCareerDataExtKenmuList = new ArrayList<PersonCareerDataExt>();
			PersonCareerDataExt personCareerDataExt = new PersonCareerDataExt();
			personCareerDataExtKenmuList.add(personCareerDataExt);
			form.setPersonCareerDataKenmuDetailList(personCareerDataExtKenmuList);
		}

		return "authorization/personcareer/detail";
	}

	private List<ListInfo> getListInfo(String key1, String key2, String key3) {

		List<ListInfo> listInfo = new ArrayList<ListInfo>();

		InformationTableExample informationTableExample = new InformationTableExample();
		com.mitsubishi.demo.common.dataset.InformationTableExample.Criteria informationTableExampleCriteria = informationTableExample
				.createCriteria();

		informationTableExampleCriteria.andKey1EqualTo(key1);

		if ("NULL".equals(key2)) {
			if ("@NULL".equals(key3)) {
				informationTableExampleCriteria.andKey3EqualTo(key3);
			}
		} else {
			informationTableExampleCriteria.andKey2EqualTo(key2);

			if ("NOTNULL".equals(key3)) {
				informationTableExampleCriteria.andKey3IsNotNull();
				informationTableExampleCriteria.andKey3NotEqualTo("@NULL");
			}
		}

		List<InformationTable> informationTableList = informationFacade.selectByExample(informationTableExample);

		for (InformationTable informationTable : informationTableList) {
			ListInfo info = new ListInfo();
			if ("NULL".equals(key2)) {
				info.setCode(informationTable.getKey2());
			} else {
				info.setCode(informationTable.getKey3());
			}
			info.setName(informationTable.getValueLong());
			listInfo.add(info);
		}

		return listInfo;
	}

	private String getInformationTableValue(String key1, String key2, String key3) {

		String value = null;
		List<InformationTable> informationTableList = getInformationTableList(key1, key2, key3);
		if (informationTableList != null && informationTableList.size() > 0) {
			value = informationTableList.get(0).getValueLong();
		}

		return value;
	}

	private List<InformationTable> getInformationTableList(String key1, String key2, String key3) {

		InformationTableExample informationTableExample = new InformationTableExample();
		com.mitsubishi.demo.common.dataset.InformationTableExample.Criteria informationTableExampleCriteria = informationTableExample
				.createCriteria();

		informationTableExampleCriteria.andKey1EqualTo(key1);
		informationTableExampleCriteria.andKey2EqualTo(key2);
		informationTableExampleCriteria.andKey3EqualTo(key3);

		List<InformationTable> informationTableList = informationFacade.selectByExample(informationTableExample);

		return informationTableList;
	}

	@RequestMapping("/doRegist")
	public String doRegist(PersonCareerForm form, BindingResult result, Model model) throws ParseException {

		int count = personCareerFacade.updatePersonCareerData(form);

		// List<PersonCareerDataExt> personCareerDataSyumuDetailList =
		// form.getPersonCareerDataSyumuDetailList();
		// if (personCareerDataSyumuDetailList != null &&
		// personCareerDataSyumuDetailList.size() > 0) {
		// for (PersonCareerDataExt personCareerDataExt :
		// personCareerDataSyumuDetailList) {
		// System.out.println(personCareerDataExt.getStartDate());
		// }
		// }

		// List<PersonCareerDataExt> list2 = form.getPersonCareerDataSyumuHistoryList();
		// List<PersonCareerDataExt> list3 = form.getPersonCareerDataKenmuDetailList();

		return "redirect:/authorization/personcareer/goRegist/" + form.getPersonTableForm().getPersonNum();
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
