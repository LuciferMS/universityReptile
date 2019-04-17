package com.reptilesysem.system.core.util.log.dao;

import org.springframework.data.repository.CrudRepository;

import com.reptilesysem.system.core.util.log.pojo.SearchHistory;

public interface ISearchHistoryDao extends CrudRepository<SearchHistory, String>{

}
