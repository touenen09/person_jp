package com.mitsubishi.demo.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	@RequestMapping("/menu")
	public String goMenu() {
		return "/menu/index";
	}

	@RequestMapping("/")
	public String goIndex() {
		return "redirect:/menu";
	}
}
