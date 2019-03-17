package com.springcloud.singlehystrix.controller;

import com.springcloud.singlehystrix.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/2.
 */
@RestController
public class HomeController {

    @Autowired
    private PrintService printService;

    @GetMapping("/print/{msg}")
    public String print(@PathVariable String msg){
        return printService.print(msg);
    }

    @GetMapping("/error/{msg}")
    public String error(@PathVariable String msg){
        return printService.error(msg);
    }
}
