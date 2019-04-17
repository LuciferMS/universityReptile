package com.reptilesysem.system.core.service.impl;

import com.reptilesysem.system.core.dao.IUserDao;
import com.reptilesysem.system.core.pojo.User;
import com.reptilesysem.system.core.service.IUserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User login(User user) {
        return null;
    }

    /**
     * 注册的时候使用md5+盐值加密
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        return userDao.save(user);
    }
}
