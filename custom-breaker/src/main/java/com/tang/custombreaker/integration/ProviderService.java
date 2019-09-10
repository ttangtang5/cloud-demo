package com.tang.custombreaker.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/27 17:19
 * @Version 1.0
 **/
@FeignClient(name = "consul-provider", contextId = "consul-provider", path = "provider")
public interface ProviderService {

    @GetMapping("hello/{name}")
    String hello(@PathVariable("name") String name);
}
