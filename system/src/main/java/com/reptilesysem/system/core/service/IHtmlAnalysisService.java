package com.reptilesysem.system.core.service;

import java.util.List;

import com.reptilesysem.system.core.pojo.HtmlAnalysis;

public interface IHtmlAnalysisService {
	
	HtmlAnalysis saveAnalysis(HtmlAnalysis analysis);
	
	HtmlAnalysis testAnalysis(String rulesId, String htmlInfoId);

	List<HtmlAnalysis> analysisByMoudle(String moudleId, String htmlInfoId);

	HtmlAnalysis analysisByRules(String ruleId, String htmlInfoId);

	HtmlAnalysis getAnalysisByRuleId(String ruleId, String htmlInfoId);

	List<HtmlAnalysis> getAnalysisByMid(String mid, String htmlInfoId);

	
}
