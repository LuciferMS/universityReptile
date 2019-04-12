package com.reptilesysem.system.core.service.impl;

import com.reptilesysem.system.core.dao.IHtmlAnalysisDao;
import com.reptilesysem.system.core.dao.ISearchDao;
import com.reptilesysem.system.core.pojo.HtmlAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.service.ISearchService;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

@Service
public class SearchServiceImpl implements ISearchService{

    @Autowired
    private ISearchDao searchDao;

    @Autowired
    private IHtmlAnalysisDao analysisDao;


    @Override
    public List<HtmlAnalysis> getHtmlAnalysis(String siteName) {
        List<HtmlAnalysis> result = analysisDao.getBySiteName(siteName);
        return result;
    }
}
