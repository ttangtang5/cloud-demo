package com.tang.hystrixdemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tang.hystrixdemo.integration.ProviderService;
import com.tang.hystrixdemo.integration.ProviderService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/28 10:56
 * @Version 1.0
 **/
@RestController
@RequestMapping("hystrix")
public class HystrixController {

    @Autowired
    private ProviderService providerService;
    @Autowired
    private ProviderService2 providerService2;

    @RequestMapping("hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return providerService.hello(name);
    }

    @RequestMapping("hello2/{name}")
    @HystrixCommand(fallbackMethod = "fallBackHello2")
    public String hello2(@PathVariable("name") String name) {
        return providerService2.hello(name);
    }


    public String fallBackHello2(String name) {
        return "fallback method";
    }
}
