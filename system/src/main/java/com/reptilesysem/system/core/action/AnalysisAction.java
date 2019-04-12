package com.reptilesysem.system.core.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.commen.base.BaseHttpCode;
import com.commen.base.BaseHttpMessage;
import com.commen.pojo.RestData;
import com.reptilesysem.system.core.dto.ModulesDto;
import com.reptilesysem.system.core.pojo.HtmlAnalysis;
import com.reptilesysem.system.core.service.IHtmlAnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *  改进方向1:RestData改成ResponseEntity
 * @author Elliot
 *
 */
@Slf4j
@RestController
@RequestMapping("/analysis")
public class AnalysisAction {
	
	@Autowired
	private IHtmlAnalysisService analysisService;

	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/testAnalysis")
	public RestData testAnalysis(String rulesId, String htmlInfoId) {
		HtmlAnalysis analysis = analysisService.testAnalysis(rulesId, htmlInfoId);
		return new RestData(BaseHttpCode.SUCCESS.getCode(), BaseHttpMessage.SUCCESS.getMessage(), analysis);
	}
	
	@PostMapping("/analysisByModule")
	public RestData analysisByModule( String moduleId , String htmlInfoId) {
		List<HtmlAnalysis> analysies = analysisService.analysisByMoudle(moduleId, htmlInfoId);
		return new RestData(BaseHttpCode.SUCCESS.getCode(), BaseHttpMessage.SUCCESS.getMessage(), analysies);
	}
	
	@PostMapping("/analysisByRules")
	public RestData analysisByRules(String ruleId, String htmlInfoId) {
		HtmlAnalysis analysis = analysisService.analysisByRules(ruleId, htmlInfoId);
		return new RestData(BaseHttpCode.SUCCESS.getCode(), BaseHttpMessage.SUCCESS.getMessage(), analysis);
	}
	
	@GetMapping("/getAnalysisByMid")
	public RestData getAnalysisByMid(String mid, String htmlInfoId) {
		List<HtmlAnalysis> htmlAnalysies = analysisService.getAnalysisByMid(mid, htmlInfoId);
		return new RestData(BaseHttpCode.SUCCESS.getCode(), BaseHttpMessage.SUCCESS.getMessage(), htmlAnalysies);
	}
	
	@GetMapping("/getAnalysisByRule")
	public RestData getAnalysisByRule(String ruleId, String htmlInfoId) {
		HtmlAnalysis analysis = analysisService.getAnalysisByRuleId(ruleId, htmlInfoId);
		return new RestData(BaseHttpCode.SUCCESS.getCode(), BaseHttpMessage.SUCCESS.getMessage(), analysis);
	}

}
