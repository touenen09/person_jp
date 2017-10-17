package com.mitsubishi.demo.functions.personjobhistory.controller;

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
import com.mitsubishi.demo.common.dataset.PersonTable;
import com.mitsubishi.demo.common.util.CssUtil;
import com.mitsubishi.demo.functions.person.facade.PersonFacade;
import com.mitsubishi.demo.functions.person.form.PersonTableForm;
import com.mitsubishi.demo.functions.personjobhistory.facade.PersonJobHistoryFacade;

@Controller
@RequestMapping("/authorization/personjobhistory")
public class PersonJobHistoryController {

	@Autowired
	PersonJobHistoryFacade personJobHistoryFacade;

	@RequestMapping("/goIndex/{confId}")
	public String goIndex(@PathVariable("confId") String confId, Model model) {

		/*
		 * if ("1".equals(confId)) { return "/authorization/person/list"; }
		 */

		List<PersonJobHistoryTable> personList = personJobHistoryFacade.selectByExample();
		model.addAttribute("page", personList);

		return "authorization/personjobhistory/list";
	}

}
