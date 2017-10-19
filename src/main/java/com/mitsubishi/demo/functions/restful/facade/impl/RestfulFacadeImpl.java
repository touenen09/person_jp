package com.mitsubishi.demo.functions.restful.facade.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.InformationTable;
import com.mitsubishi.demo.common.dataset.InformationTableExample;
import com.mitsubishi.demo.common.entity.ListInfo;
import com.mitsubishi.demo.common.service.InformationTableService;
import com.mitsubishi.demo.functions.restful.facade.RestfulFacade;

@Service
public class RestfulFacadeImpl implements RestfulFacade {

	@Autowired
	InformationTableService informationTableService;

	@Override
	public List<ListInfo> selectListInfoByKey(String key1, String key2) {

		List<ListInfo> returnList = new ArrayList<ListInfo>();

		List<InformationTable> infoList = selectByKey(key1, key2);

		if (infoList != null && infoList.size() > 0) {
			for (InformationTable informationTable : infoList) {
				ListInfo info = new ListInfo();
				info.setCode(informationTable.getKey3());
				info.setName(informationTable.getValueLong());
				returnList.add(info);
			}
		}
		return returnList;
	}

	@Override
	public List<InformationTable> selectByKey(String key1, String key2) {

		InformationTableExample informationTableExample = new InformationTableExample();
		com.mitsubishi.demo.common.dataset.InformationTableExample.Criteria informationTableExampleCriteria = informationTableExample
				.createCriteria();
		informationTableExampleCriteria.andKey1EqualTo(key1);
		informationTableExampleCriteria.andKey2EqualTo(key2);
		informationTableExampleCriteria.andKey3NotEqualTo("@NULL");

		List<InformationTable> list = selectByExample(informationTableExample);
		return list;
	}

	@Override
	public List<InformationTable> selectByExample(InformationTableExample example) {

		return informationTableService.selectByExample(example);
	}

}
