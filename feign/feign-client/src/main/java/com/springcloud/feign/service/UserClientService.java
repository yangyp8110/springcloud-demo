package com.springcloud.feign.service;

import com.springcloud.feign.api.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author mr.yang
 * @date 2019/3/2
 */
@FeignClient(value = "user-service")
public interface UserClientService extends UserService {

}
