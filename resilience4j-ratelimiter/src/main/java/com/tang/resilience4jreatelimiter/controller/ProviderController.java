package com.tang.resilience4jreatelimiter.controller;

import com.tang.resilience4jreatelimiter.interaction.ProviderService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/29 11:14
 * @Version 1.0
 **/
@RestController
@RequestMapping("provider")
@RateLimiter(name = "hello")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("test")
    public String test() {
        return providerService.hello("test");
    }
}
