package com.tang.resilience4jreatelimiter.controller;

import com.tang.resilience4jreatelimiter.interaction.ProviderService;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/29 11:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ProviderService providerService;

    private RateLimiter rateLimiter;

    public TestController(RateLimiterRegistry rateLimiterRegistry) {
        rateLimiter = rateLimiterRegistry.rateLimiter("hello");
    }

    @RequestMapping("java")
    public String test() {
        String test = RateLimiter.decorateSupplier(rateLimiter, () -> providerService.hello("test"))
                .get();
        return test;
    }

    @RequestMapping("annotation")
    @io.github.resilience4j.ratelimiter.annotation.RateLimiter(name = "hello2")
    public String test2() {
        return providerService.hello("annotation");
    }

}
