package com.tang.feigncustomer.integration;

import com.tang.feigncustomer.model.CoffeeOrder;
import com.tang.feigncustomer.model.NewOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// @FeignClient(value = "waiter2", contextId = "coffeeOrder", path = "/order") name和value的作用好像等价
@FeignClient(value = "waiter2", contextId = "coffeeOrder", path = "/order")
public interface CoffeeOrderService {

    @GetMapping("/{id}")
    CoffeeOrder getOrder(@PathVariable("id") Long id);

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    CoffeeOrder create(@RequestBody NewOrderRequest newOrder);
}
