package com.reptilesysem.system.core.action;


import com.commen.pojo.RestData;
import com.reptilesysem.system.core.pojo.HtmlAnalysis;
import com.reptilesysem.system.core.pojo.SearchHistory;
import com.reptilesysem.system.core.service.IHtmlAnalysisService;
import com.reptilesysem.system.core.service.ISearchHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpLogging;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/search")
public class SearchAction {

    @Autowired
    private ISearchHistoryService historyService;

    @Autowired
    private IHtmlAnalysisService analysisService;

	@GetMapping("/commentSearch")
	public RestData commentSearch(String siteName) {
	    List<HtmlAnalysis> analysis = analysisService.getAnalysisByName(siteName);
        SearchHistory history = SearchHistory.builderOfSuccess().value(siteName);
        historyService.saveHistory(history);
        return RestData.builderOfSuccess().details(analysis);
	}

}
