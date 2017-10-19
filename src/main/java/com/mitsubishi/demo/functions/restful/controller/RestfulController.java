package com.mitsubishi.demo.functions.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitsubishi.demo.common.entity.ListInfo;
import com.mitsubishi.demo.functions.restful.facade.RestfulFacade;
import com.mitsubishi.demo.functions.restful.json.JsonResponse;

@Controller
@RequestMapping("/authorization/ajax")
public class RestfulController {

	@Autowired
	RestfulFacade restfulFacade;

	@RequestMapping(value = "/product/detail/{key2}", method = {
			RequestMethod.GET }, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public JsonResponse<List<ListInfo>> getProductDetailListJSON(@PathVariable("key2") String key2) {

		List<ListInfo> list = restfulFacade.selectListInfoByKey("Product", key2);
		return new JsonResponse<List<ListInfo>>(list);
	}

	@RequestMapping(value = "/function/detail/{key2}", method = {
			RequestMethod.GET }, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public JsonResponse<List<ListInfo>> getFunctionDetailListJSON(@PathVariable("key2") String key2) {

		List<ListInfo> list = restfulFacade.selectListInfoByKey("Function", key2);
		return new JsonResponse<List<ListInfo>>(list);
	}
}
