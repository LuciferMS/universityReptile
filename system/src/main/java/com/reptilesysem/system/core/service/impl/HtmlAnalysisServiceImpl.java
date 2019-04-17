package com.reptilesysem.system.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.dao.IHtmlAnalysisDao;
import com.reptilesysem.system.core.dao.IHtmlInfoDao;
import com.reptilesysem.system.core.dao.IMoudlesDao;
import com.reptilesysem.system.core.dao.IRulesDao;
import com.reptilesysem.system.core.pojo.HtmlAnalysis;
import com.reptilesysem.system.core.pojo.HtmlInfo;
import com.reptilesysem.system.core.pojo.Rules;
import com.reptilesysem.system.core.service.IHtmlAnalysisService;

@Slf4j
@Service
public class HtmlAnalysisServiceImpl implements IHtmlAnalysisService{
	
	@Autowired
	private IHtmlAnalysisDao analysisDao;
	
	@Autowired
	private IHtmlInfoDao htmlInfoDao;
	
	@Autowired
	private IRulesDao rulesDao;
	
	@Autowired
	private IMoudlesDao moduleDao;

	@Override
	public HtmlAnalysis saveAnalysis(HtmlAnalysis analysis) {
		return analysisDao.save(analysis);
	}

	@Override
	public HtmlAnalysis testAnalysis(String rulesId, String htmlInfoId) {
		Rules rules = rulesDao.findById(rulesId).get();
		HtmlInfo htmlInfo = htmlInfoDao.findById(htmlInfoId).get();
		Document doc = Jsoup.parse(htmlInfo.getHtml());
		Elements resultLinks = doc.select(rules.getValue());
		String result = resultLinks.toString();
		HtmlAnalysis analysis = new HtmlAnalysis(result, rules.getType(), htmlInfoId, rulesId, rules.getMid());
		return analysis;
	}

	@Override
	public List<HtmlAnalysis> analysisByMoudle(String mid, String htmlInfoId) {
		HtmlInfo htmlInfo = htmlInfoDao.findById(htmlInfoId).get();
		Document doc = Jsoup.parse(htmlInfo.getHtml());
		List<Rules> rules = rulesDao.findAllByMid(mid);
		List<HtmlAnalysis> analysies = new ArrayList<HtmlAnalysis>();
		rules.stream().forEach((item) -> {
			Elements resultLinks = doc.select(item.getValue());
			String result = resultLinks.toString();
			HtmlAnalysis analysis = new HtmlAnalysis(result, item.getType(), htmlInfoId, item.getRid(), mid);
			analysisDao.save(analysis);
			analysies.add(analysis);
		});
		return analysies;
	}

	@Override
	public HtmlAnalysis analysisByRules(String ruleId, String htmlInfoId) {
		Rules rules = rulesDao.findById(ruleId).get();
		HtmlInfo htmlInfo = htmlInfoDao.findById(htmlInfoId).get();
		Document doc = Jsoup.parse(htmlInfo.getHtml());
		Elements resultLinks = doc.select(rules.getValue());
		String result = resultLinks.toString();
		HtmlAnalysis analysis = new HtmlAnalysis(result, rules.getType(), htmlInfoId, ruleId, rules.getMid());
		return analysisDao.save(analysis);
	}

	@Override
	public HtmlAnalysis getAnalysisByRuleId(String ruleId, String htmlInfoId) {
		HtmlAnalysis analysis = analysisDao.findByRIdAndHtmlInfoId(ruleId, htmlInfoId);
		return analysis;
	}

	@Override
	public List<HtmlAnalysis> getAnalysisByMid(String mid, String htmlInfoId) {
		List<HtmlAnalysis> htmlAnalysies = analysisDao.findByMIdAndHtmlInfoId(mid, htmlInfoId);
		return htmlAnalysies;
	}

    @Override
    public List<HtmlAnalysis> getAnalysisByName(String siteName) {
        return analysisDao.getBySiteName(siteName);
    }

}
