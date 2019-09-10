package com.tang.hystrixbashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 开启DashBoard注解 访问：http://localhsot:{port}/hystrix
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixBashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixBashboardApplication.class, args);
    }

}
