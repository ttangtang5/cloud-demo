package com.tang.consulcustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/27 15:30
 * @Version 1.0
 **/
@Component
public class CustomRunner implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String consul = restTemplate.getForObject("http://consul-provider/provider/hello/{1}", String.class, "consul");
        System.out.println(consul);
    }
}
