package com.reptilesysem.system.core.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reptilesysem.system.core.pojo.MoudleHtmlInfoRef;

public interface IMoudleHtmlRefDao extends CrudRepository<MoudleHtmlInfoRef, String>{

	public List<MoudleHtmlInfoRef> findByHtmlInfoId(String htmlInfoId);

}
