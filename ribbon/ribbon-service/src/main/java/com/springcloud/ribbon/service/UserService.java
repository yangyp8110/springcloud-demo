package com.springcloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mr.yang on 2019/3/3.
 */
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public UserDto getUser(Long userId) {
        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://service-1/getUser/{1}", UserDto.class, userId);
        return responseEntity.getBody();
    }
}
