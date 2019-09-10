package com.tang.resilience4jblukhead.controller;

import com.tang.resilience4jblukhead.interaction.ProviderService;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerOpenException;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/29 10:16
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    private CircuitBreaker circuitBreaker;

    private Bulkhead bulkhead;

    public ProviderController (CircuitBreakerRegistry circuitBreakerRegistry, BulkheadRegistry bulkheadRegistry) {
        circuitBreaker = circuitBreakerRegistry.circuitBreaker("hello");
        bulkhead = bulkheadRegistry.bulkhead("hello");
    }

    @RequestMapping("hello")
    public String hello() {
        return Try.ofSupplier(
                Bulkhead.decorateSupplier(bulkhead,
                        CircuitBreaker.decorateSupplier(circuitBreaker,
                                () -> providerService.hello("bulkhead"))))
                .recover(CircuitBreakerOpenException.class, "ciruitBreaker error")
                .recover(BulkheadFullException.class, "bulkhead error")
                .get();
    }

    @RequestMapping("hello2")
    @io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "hello2")
    @io.github.resilience4j.bulkhead.annotation.Bulkhead(name = "hello2")
    public String hello2() {
        return providerService.hello("bulkhead");
    }
}
