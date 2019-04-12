package com.reptilesysem.system.core.dao;


import com.reptilesysem.system.core.pojo.HtmlInfo;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface IHtmlInfoDao extends CrudRepository<HtmlInfo, String> {
//    @Query(value = "select new HtmlInfo (h.id,h.name,h.html,h.url) " +
//            "from HtmlInfo h " +
//            "where h.name like concat('%' , :name , '%') ")
//    public List<HtmlInfo> getHtmlInfoByName(@Param("name") String name);
//
//    @Query(value = "select new HtmlInfo(h.id,h.name,h.html,h.url) from HtmlInfo h")
//    public List<HtmlInfo> getAllBaseInfo();
//
//    @Query(value = "select new HtmlInfo(h.id,h.name,h.html,h.url) " +
//            "from HtmlInfo h " +
//            "where h.url = :url")
//    public HtmlInfo getHtmlInfoByUrl(@Param("url") String url);
//
//    @Query(value = "select new HtmlInfo(h.id,h.name,h.html,h.url) " +
//            "from HtmlInfo h " +
//            "where h.id = :id")
//    public HtmlInfo getHtmlInfoById(@Param("id") String id);
	public List<HtmlInfo> findByName(String name);
	
	public HtmlInfo findByUrl(String url);
	
	public Optional<HtmlInfo> findById(String id);
}
