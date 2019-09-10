package com.tang.resilience4jdemo.controller;

import com.tang.resilience4jdemo.integration.ProviderService;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @Description resilience4j spring boot2
 * @Author RLY
 * @Date 2019/5/28 15:54
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ProviderService providerService;

    private CircuitBreaker circuitBreaker;

    public TestController(CircuitBreakerRegistry registry) {
        circuitBreaker = registry.circuitBreaker("hello");
    }

    @RequestMapping("hello")
    public String hello() {
        return Try.ofSupplier(
                CircuitBreaker.decorateSupplier(circuitBreaker,
                        () -> providerService.hello("circuitBreaker")))
                .recover(CircuitBreakerOpenException.class, "error")
                .get();
    }

    @RequestMapping("hello2")
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "hello2")
    public String hello2() {
        return providerService.hello("annotation circuitBreaker");
    }
}
