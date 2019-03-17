package com.springcloud.hystrix.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by mr.yang on 2019/3/3.
 */
@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserFallBack")
    public UserDto getUser() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(new Random().nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://service-1/getUser/{1}", UserDto.class, 2000);
        long end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start));
        return responseEntity.getBody();
    }

    public UserDto getUserFallBack() {
        UserDto userDto = new UserDto();
        userDto.setUserId(9999L);
        userDto.setName("fall back");
        return userDto;
    }
}
