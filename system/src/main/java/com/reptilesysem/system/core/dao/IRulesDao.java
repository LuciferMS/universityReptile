package com.reptilesysem.system.core.dao;


import java.util.List;


import com.commen.jpa.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.reptilesysem.system.core.pojo.Rules;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IRulesDao extends CrudRepository<Rules, String>,JpaSpecificationExecutor<Rules> {

    @Query(
            value = "select new Rules(r.rid, r.ruleName, r.value, r.type, r.mid, r.createTime, r.lastUpdateTime, r.status, r.useTimes) from Rules r " +
                    "where r.mid = :mid",
            nativeQuery = false
    )
	List<Rules> findAllByMid(@Param("mid") String mid);

    @Query(
            value = "select new Rules(r.rid, r.ruleName, r.value, r.type, r.mid, r.createTime, r.lastUpdateTime, r.status, r.useTimes) from Rules r " ,
            nativeQuery = false
    )
    List<Rules> finaAllRules();
	
}
