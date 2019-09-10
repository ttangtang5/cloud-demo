package com.tang.resilience4jblukhead.interaction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/29 10:14
 * @Version 1.0
 **/
@FeignClient(name = "consul-provider", contextId = "provider", path = "provider")
public interface ProviderService {

    @GetMapping("hello/{name}")
    String hello(@PathVariable("name") String name);
}
