package com.reptilesysem.system.core.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commen.base.BaseHttpCode;
import com.commen.base.BaseHttpMessage;
import com.commen.pojo.RestData;
import com.reptilesysem.system.core.dto.RuleDto;
import com.reptilesysem.system.core.pojo.Rules;
import com.reptilesysem.system.core.service.IRulesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rules")
public class RulesAction {
	
	@Autowired
	private IRulesService rulesService;
	
	@PostMapping("/createRules")
	public RestData createRules(Rules rule) {
		rulesService.saveRule(rule);
		return RestData.builderOfSuccess().details("创建规则成功");
	}
	
	@GetMapping("getRulesByMid")
	public RestData getRulesByMid(RuleDto dto) {
		List<Rules> rules = rulesService.getAllRulesByMid(dto);
        return RestData.builderOfSuccess().details(rules);
	}
	
	@GetMapping("/getRulesByHtmlId")
	public RestData getRulesByHtmlId(String htmlId) {
		List<Rules> rules = rulesService.getRulesByHtmlId(htmlId);
        return RestData.builderOfSuccess().details(rules);
	}
	
	@PostMapping("freezeRules")
	public RestData freezeRule() {
        return RestData.builderOfSuccess().details("冻结规则成功");
	}
	
	@GetMapping("/getAllRules")
	public RestData getAllRules() {
		List<Rules> rules = rulesService.getAllRules();
        return RestData.builderOfSuccess().details(rules);
	}
}
