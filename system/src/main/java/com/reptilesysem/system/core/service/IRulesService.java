package com.reptilesysem.system.core.service;

import java.util.List;

import com.reptilesysem.system.core.dto.RuleDto;
import com.reptilesysem.system.core.pojo.Rules;
import org.dom4j.rule.Rule;

public interface IRulesService {

	Rules saveRule(Rules rule);

	List<Rules> getAllRulesByMid(RuleDto dto);

	List<Rules> getAllRules();

	List<Rules> getRulesByHtmlId(String htmlId);

    Integer freezeRule(String ruleId);
}
