package com.mitsubishi.demo.functions.restful.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static Map<String, String> groupKey1ProductMap = new HashMap<String, String>();
	private static Map<String, String> groupKey1FunctionMap = new HashMap<String, String>();

	static {
		groupKey1ProductMap.put("01", "Product1");
		groupKey1ProductMap.put("02", "Product2");
		groupKey1ProductMap.put("03", "Product3");
		groupKey1FunctionMap.put("01", "Function1");
		groupKey1FunctionMap.put("02", "Function2");
		groupKey1FunctionMap.put("03", "Function3");
	}

	public Map<String, String> getGroupKey1ProductMap() {
		return groupKey1ProductMap;
	}

	public Map<String, String> getGroupKey1FunctionMap() {
		return groupKey1FunctionMap;
	}

	@RequestMapping(value = "/product/detail/{group1}/{key2}", method = {
			RequestMethod.GET }, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public JsonResponse<List<ListInfo>> getProductDetailListJSON(@PathVariable("group1") String group1,
			@PathVariable("key2") String key2) {

		String key1 = groupKey1ProductMap.get(group1);
		List<ListInfo> list = restfulFacade.selectListInfoByKey(key1, key2);
		return new JsonResponse<List<ListInfo>>(list);
	}

	@RequestMapping(value = "/function/detail/{group1}/{key2}", method = {
			RequestMethod.GET }, produces = "application/json; charset=UTF-8")
	@ResponseBody
	public JsonResponse<List<ListInfo>> getFunctionDetailListJSON(@PathVariable("group1") String group1,
			@PathVariable("key2") String key2) {

		String key1 = groupKey1FunctionMap.get(group1);
		List<ListInfo> list = restfulFacade.selectListInfoByKey(key1, key2);
		return new JsonResponse<List<ListInfo>>(list);
	}
}
