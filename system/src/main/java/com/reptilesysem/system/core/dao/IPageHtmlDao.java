package com.reptilesysem.system.core.dao;

import com.reptilesysem.system.core.pojo.HtmlQueueInfo;
import org.springframework.data.repository.CrudRepository;

public interface IPageHtmlDao extends CrudRepository<HtmlQueueInfo, String> {

}
