package com.springcloud.hystrix.demo.controller;

import com.springcloud.hystrix.demo.service.UserDto;
import com.springcloud.hystrix.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/2.
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public UserDto getUser(){
        return userService.getUser();
    }
}
