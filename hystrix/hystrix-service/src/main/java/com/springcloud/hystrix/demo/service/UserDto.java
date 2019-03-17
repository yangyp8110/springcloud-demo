package com.springcloud.hystrix.demo.service;

/**
 * Created by mr.yang on 2019/3/3.
 */
public class UserDto {
    private Long userId;
    private String name;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
