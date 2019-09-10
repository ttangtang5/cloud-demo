package com.tang.resilience4jreatelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Resilience4jReatelimiterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Resilience4jReatelimiterApplication.class, args);
    }

}
