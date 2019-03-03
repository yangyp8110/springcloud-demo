package com.eureka.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mr.yang on 2019/3/2.
 */
@RestController
public class HomeController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hs")
    public String index() {
        return "OK " + port;
    }

    @GetMapping("/getUser/{userId}")
    public UserDto getUserByUserId(@PathVariable Long userId) {
        System.out.println(port + " provides service");
        UserDto userDto = new UserDto();
        userDto.setName("zhangsan");
        userDto.setUserId(userId);
        return userDto;
    }
}
