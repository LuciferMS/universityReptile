package com.reptilesysem.system.core.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.reptilesysem.system.core.pojo.Moudles;

import java.util.List;

public interface IMoudlesDao extends CrudRepository<Moudles, String>{

}
