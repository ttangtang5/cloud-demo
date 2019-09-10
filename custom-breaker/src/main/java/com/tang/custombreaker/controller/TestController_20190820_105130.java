package com.tang.custombreaker.controller;

import com.tang.custombreaker.integration.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/27 17:23
 * @Version 1.0
 **/
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/{name}")
    public String test(@PathVariable("name") String name) {
        return providerService.hello(name);
    }
}
