package com.springcloud.peer2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/2.
 */
@RestController
public class HomeController {
    @RequestMapping("/hs")
    public String index() {
        return "peer2 start success";
    }
}
