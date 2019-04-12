package com.reptilesysem.system.core.service;

import com.reptilesysem.system.core.pojo.HtmlAnalysis;

import java.util.List;

public interface ISearchService {

    List<HtmlAnalysis> getHtmlAnalysis(String siteName);

}
