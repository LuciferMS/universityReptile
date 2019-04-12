package com.reptilesysem.system.core.action;


import com.commen.base.BaseHttpCode;
import com.commen.base.BaseHttpMessage;
import com.commen.pojo.RestData;
import com.reptilesysem.system.core.pojo.HtmlAnalysis;
import com.reptilesysem.system.core.pojo.SearchHistory;
import com.reptilesysem.system.core.service.ISearchHistoryService;
import com.reptilesysem.system.core.service.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ISearchService searchService;

	@GetMapping("/commentSearch")
	public RestData commentSearch(String siteName) {
        List<HtmlAnalysis> htmlAnalyses = searchService.getHtmlAnalysis(siteName);
        historyService.saveHistory(new SearchHistory(siteName));
		return new RestData(
                    BaseHttpCode.SUCCESS.getCode(),
                    BaseHttpMessage.SUCCESS.getMessage(),
                    htmlAnalyses
        );
	}
}
