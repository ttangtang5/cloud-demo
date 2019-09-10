package com.tang.hystrixdemo.integration;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/28 11:00
 * @Version 1.0
 **/
@Component
public class ProviderServiceFallback implements ProviderService {

    @Override
    public String hello(String name) {
        return "hello hystrix";
    }
}
