package com.reptilesysem.system.core.dao;

import com.reptilesysem.system.core.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, String> {

}
