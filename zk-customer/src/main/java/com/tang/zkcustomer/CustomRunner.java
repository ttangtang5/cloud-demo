package com.tang.zkcustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/27 9:42
 * @Version 1.0
 **/
@Component
public class CustomRunner implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String object = restTemplate.getForObject("http://zk-provider/provider/hello?name={1}", String.class, "zookeeper");
        System.out.println(object);
    }
}
