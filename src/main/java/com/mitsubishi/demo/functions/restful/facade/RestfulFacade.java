package com.mitsubishi.demo.functions.restful.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitsubishi.demo.common.dataset.InformationTable;
import com.mitsubishi.demo.common.dataset.InformationTableExample;
import com.mitsubishi.demo.common.entity.ListInfo;

@Service
public interface RestfulFacade {

	List<ListInfo> selectListInfoByKey(String key1, String key2);

	List<InformationTable> selectByKey(String key1, String key2);

	List<InformationTable> selectByExample(InformationTableExample example);
}
