package com.mitsubishi.demo.functions.personjobhistory.controller;

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
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTable;
import com.mitsubishi.demo.common.dataset.PersonJobHistoryTableKey;
import com.mitsubishi.demo.common.util.CssUtil;
import com.mitsubishi.demo.common.util.DateUtil;
import com.mitsubishi.demo.functions.personjobhistory.facade.PersonJobHistoryFacade;
import com.mitsubishi.demo.functions.personjobhistory.form.PersonJobHistoryTableForm;

@Controller
@RequestMapping("/authorization/personjobhistory")
public class PersonJobHistoryController {

	@Autowired
	PersonJobHistoryFacade personJobHistoryFacade;

	@ModelAttribute
	public PersonJobHistoryTableForm getPersonJobHistoryTableForm() {
		return new PersonJobHistoryTableForm();
	}

	@RequestMapping("/goIndex/{confId}")
	public String goIndex(@PathVariable("confId") String confId, Model model) {

		/*
		 * if ("1".equals(confId)) { return "/authorization/personjobhistory/list"; }
		 */
		List<PersonJobHistoryTableForm> personJobHistoryFormList = new ArrayList<PersonJobHistoryTableForm>();

		List<PersonJobHistoryTable> personJobHistoryList = personJobHistoryFacade.selectByExample();

		for (PersonJobHistoryTable personJobHistoryTable : personJobHistoryList) {
			PersonJobHistoryTableForm personJobHistoryTableForm = new PersonJobHistoryTableForm();
			BeanUtils.copyProperties(personJobHistoryTable, personJobHistoryTableForm);
			personJobHistoryTableForm.setEffectiveDateString(DateUtil
					.convertDateToString(personJobHistoryTableForm.getEffectiveDate(), DateUtil.DATE_PATTERN_DATE));
			personJobHistoryFormList.add(personJobHistoryTableForm);
		}

		model.addAttribute("page", personJobHistoryFormList);

		return "authorization/personjobhistory/list";
	}

	@RequestMapping("/goRegist")
	public String goRegist(Model model) {

		CssUtil.setButtonCss(model, ComConst.C_REGIST);
		return "authorization/personjobhistory/detail";
	}

	@RequestMapping("/doRegist")
	public String doRegist(PersonJobHistoryTableForm form, BindingResult result, Model model) throws ParseException {

		form.setEffectiveDate(DateUtil.convertStringToDate(form.getEffectiveDateString(), DateUtil.DATE_PATTERN_DATE));

		PersonJobHistoryTable personJobHistoryTable = new PersonJobHistoryTable();
		BeanUtils.copyProperties(form, personJobHistoryTable);
		personJobHistoryFacade.insertSelective(personJobHistoryTable);
		return "redirect:/authorization/personjobhistory/goIndex/1";
	}

	@RequestMapping("/goUpdate/{personNum}/{appointment}/{effectiveDateString}")
	public String goUpdate(PersonJobHistoryTableForm form, @PathVariable("personNum") String personNum,
			@PathVariable("appointment") String appointment,
			@PathVariable("effectiveDateString") String effectiveDateString, Model model) throws ParseException {

		CssUtil.setButtonCss(model, ComConst.C_UPDATE);

		PersonJobHistoryTableKey key = new PersonJobHistoryTableKey();
		key.setPersonNum(personNum);
		key.setAppointment(appointment);
		key.setEffectiveDate(DateUtil.convertStringToDate(effectiveDateString, DateUtil.DATE_PATTERN_DATE));

		PersonJobHistoryTable personJobHistoryTable = personJobHistoryFacade.selectByPrimaryKey(key);
		BeanUtils.copyProperties(personJobHistoryTable, form);
		form.setEffectiveDateString(DateUtil.convertDateToString(form.getEffectiveDate(), DateUtil.DATE_PATTERN_DATE));

		return "authorization/personjobhistory/detail";
	}

	@RequestMapping("/doUpdate")
	public String doUpdate(PersonJobHistoryTableForm form, BindingResult result, Model model) throws ParseException {

		form.setEffectiveDate(DateUtil.convertStringToDate(form.getEffectiveDateString(), DateUtil.DATE_PATTERN_DATE));
		PersonJobHistoryTable personJobHistoryTable = new PersonJobHistoryTable();
		BeanUtils.copyProperties(form, personJobHistoryTable);
		personJobHistoryFacade.updateByPrimaryKey(personJobHistoryTable);
		return "redirect:/authorization/personjobhistory/goIndex/1";
	}

	@RequestMapping("/doDelete")
	public String doDelete(PersonJobHistoryTableForm form, BindingResult result, Model model) throws ParseException {

		form.setEffectiveDate(DateUtil.convertStringToDate(form.getEffectiveDateString(), DateUtil.DATE_PATTERN_DATE));

		PersonJobHistoryTableKey key = new PersonJobHistoryTableKey();
		key.setPersonNum(form.getPersonNum());
		key.setAppointment(form.getAppointment());
		key.setEffectiveDate(form.getEffectiveDate());
		personJobHistoryFacade.deleteByPrimaryKey(key);
		return "redirect:/authorization/personjobhistory/goIndex/1";
	}

}
