package com.reptilesysem.system.core.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reptilesysem.system.core.pojo.RuleHtmlInfoRef;

public interface IRuleHtmlRefDao extends CrudRepository<RuleHtmlInfoRef, String>{
	
	public List<RuleHtmlInfoRef> findByHtmlInfoId(String htmlInfoId);;
	
}
