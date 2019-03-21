package com.springcloud.feign.controller;

import com.springcloud.feign.service.UserClientService;
import dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/21.
 */
@RestController
@RequestMapping("/client")
public class UserClientController {
    @Autowired
    private UserClientService userClientService;

    @RequestMapping("/getUserByUserId")
    public UserDto getUserByUserId(@RequestParam("userId") Integer userId) {
        return userClientService.getUserByUserId(userId);
    }

    @RequestMapping("/getUserName")
    public String getUserName(@RequestParam("userId") Integer userId) {
        return userClientService.getUserName(userId);
    }

    @RequestMapping("/addUser")
    public Boolean addUser() {
        UserDto userDto = new UserDto();
        userDto.setDesc("register a user");
        userDto.setUserName("a new user");
        return userClientService.addUser(userDto);
    }
}
