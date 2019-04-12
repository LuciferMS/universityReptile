package com.reptilesysem.system.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reptilesysem.system.core.dao.ISearchHistoryDao;
import com.reptilesysem.system.core.pojo.SearchHistory;
import com.reptilesysem.system.core.service.ISearchHistoryService;

@Service
public class HistorySearchServiceImpl implements ISearchHistoryService{

	@Autowired
	private ISearchHistoryDao searchHistoryDao;

	@Override
	public SearchHistory saveHistory(SearchHistory history) {
		return searchHistoryDao.save(history);
	}
}
