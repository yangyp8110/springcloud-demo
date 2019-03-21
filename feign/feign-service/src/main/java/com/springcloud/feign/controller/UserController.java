package com.springcloud.feign.controller;

import com.springcloud.feign.api.UserService;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mr.yang
 * @date 2019/3/2
 */
@RestController
public class UserController implements UserService {
    @Value("${server.port}")
    private String port;

    @Override
    public UserDto getUserByUserId(@RequestParam("userId") Integer userId) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setUserName("zhang san");
        userDto.setDesc("zhang san is a good person " + port);
        return userDto;
    }

    @Override
    public String getUserName(@RequestHeader("userId") Integer userId) {
        return userId % 2 == 0 ? "zhangsan" : "lisi";
    }

    @Override
    public Boolean addUser(@RequestBody UserDto userDto) {
        System.out.println("add user " + userDto.toString() + " success ");
        return Boolean.TRUE;
    }
}
