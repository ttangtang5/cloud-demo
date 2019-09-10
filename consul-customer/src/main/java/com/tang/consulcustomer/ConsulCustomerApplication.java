package com.tang.consulcustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulCustomerApplication.class, args);
    }

}
