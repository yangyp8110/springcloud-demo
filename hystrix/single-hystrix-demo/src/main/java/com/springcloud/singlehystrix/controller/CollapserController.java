package com.springcloud.singlehystrix.controller;

import com.springcloud.singlehystrix.cache.User;
import com.springcloud.singlehystrix.collapser.UserCollapserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/19.
 */
@RestController
@RequestMapping("/collapser")
public class CollapserController {
    @Autowired
    private UserCollapserService userCollapserService;

    @GetMapping("/getUser/{userId}")
    public String getUserByUserId(@PathVariable Integer userId) {
        User user1 = userCollapserService.getUserByUserId(1001);
        User user2 = userCollapserService.getUserByUserId(1002);
        User user3 = userCollapserService.getUserByUserId(1003);
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());

        return user1.toString() + "\n" +
                user2.toString() + "\n" +
                user3.toString();
    }
}
