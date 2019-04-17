package com.reptilesysem.system.core.service;

import com.reptilesysem.system.core.pojo.User;

public interface IUserService {

    User login(User user);

    User register(User user);
}
