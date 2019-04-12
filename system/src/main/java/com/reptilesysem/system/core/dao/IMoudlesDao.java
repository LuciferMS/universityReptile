package com.reptilesysem.system.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reptilesysem.system.core.pojo.Moudles;

import java.util.List;

public interface IMoudlesDao extends CrudRepository<Moudles, String>{

    @Query(
            value = "select new Moudles(m.mouName,m.createDate, m.lastUpdateDate , m.status) from Moudles m",
            nativeQuery = false)
    List<Moudles> findAllMoudles();
}
