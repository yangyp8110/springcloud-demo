package com.springcloud.ribbon.controller;

import com.springcloud.ribbon.service.UserDto;
import com.springcloud.ribbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/2.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/getByUserId")
    public UserDto getUserByUserId() {
        UserDto user = userService.getUser(1000L);
        if (user != null) {
            System.out.println("userName:" + user.getName());
        }
        return user;
    }
}
