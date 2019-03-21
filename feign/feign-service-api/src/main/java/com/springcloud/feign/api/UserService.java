package com.springcloud.feign.api;

import dto.UserDto;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author mr.yang
 * @date 2019/3/2
 */
@RequestMapping("/userService")
public interface UserService {
    @RequestMapping(value = "getUserById", method = RequestMethod.GET)
    UserDto getUserByUserId(@RequestParam("userId")Integer userId);

    @RequestMapping(value = "getUserName", method = RequestMethod.GET)
    String getUserName(@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "getUserName", method = RequestMethod.POST)
    Boolean addUser(@RequestBody UserDto userDto);
}
