package com.reptilesysem.system.core.action;

import com.commen.pojo.RestData;
import com.reptilesysem.system.core.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserAction {

    @PostMapping("/login")
    public RestData toLogin(String username, String password){
        return RestData.builderOfSuccess().details(null);
    }

    @PostMapping("/register")
    public RestData toRegister(User user){
        return RestData.builderOfSuccess().details(null);
    }

}
