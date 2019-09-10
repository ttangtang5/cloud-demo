package com.tang.consulconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsulConfigServerApplication implements CommandLineRunner {

    @Value("${consulPro}")
    private String consulPro;

    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(consulPro);
    }
}
