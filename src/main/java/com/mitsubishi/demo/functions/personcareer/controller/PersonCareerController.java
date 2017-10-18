package com.mitsubishi.demo.functions.personcareer.controller;

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
import com.mitsubishi.demo.common.dataset.PersonTable;
import com.mitsubishi.demo.common.util.CssUtil;
import com.mitsubishi.demo.functions.person.facade.PersonFacade;
import com.mitsubishi.demo.functions.person.form.PersonTableForm;

@Controller
@RequestMapping("/authorization/personcareer")
public class PersonCareerController {

	@Autowired
	PersonFacade personFacade;

	@ModelAttribute
	public PersonTableForm getPersonTableForm() {
		return new PersonTableForm();
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

	@RequestMapping("/goRegist")
	public String goRegist(Model model) {

		CssUtil.setButtonCss(model, ComConst.C_REGIST);
		return "authorization/personcareer/detail";
	}

	@RequestMapping("/doRegist")
	public String doRegist(PersonTableForm form, BindingResult result, Model model) {

		PersonTable personTable = new PersonTable();
		BeanUtils.copyProperties(form, personTable);
		personFacade.insertSelective(personTable);
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
