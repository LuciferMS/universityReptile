package com.reptilesysem.system.core.service;

import java.util.List;

import com.reptilesysem.system.core.dto.RuleDto;
import com.reptilesysem.system.core.pojo.Rules;

public interface IRulesService {

	Rules saveRule(Rules rule);

	List<Rules> getAllRulesByMid(RuleDto dto);

	List<Rules> getAllRules();

	List<Rules> getRulesByHtmlId(String htmlId);
	
}
