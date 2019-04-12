package com.reptilesysem.system.core.dao;

import com.reptilesysem.system.core.pojo.Search;
import org.springframework.data.repository.CrudRepository;

public interface ISearchDao extends CrudRepository<Search, String> {
}
