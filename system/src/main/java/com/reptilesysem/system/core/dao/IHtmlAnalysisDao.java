package com.reptilesysem.system.core.dao;

import java.util.List;

import com.reptilesysem.system.core.pojo.HtmlAnalysis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface IHtmlAnalysisDao extends CrudRepository<HtmlAnalysis, String>{

	public List<HtmlAnalysis> findByHtmlInfoId(String htmlInfoId);

	public HtmlAnalysis findByRIdAndHtmlInfoId(String ruleId, String htmlInfoId);

	public List<HtmlAnalysis> findByMIdAndHtmlInfoId(String mid, String htmlInfoId);

	@Query(value = "SELECT * FROM t_htmlanalysis h WHERE h.htmlInfoId IN (" +
            "   SELECT i.id FROM t_htmlInfo i WHERE i.name LIKE CONCAT('%', :siteName, '%'))",
			nativeQuery = true)
    public List<HtmlAnalysis> getBySiteName(@Param("siteName") String siteName);
}
