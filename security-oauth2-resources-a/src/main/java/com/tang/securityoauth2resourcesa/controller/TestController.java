package com.tang.securityoauth2resourcesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/28 15:04
 * @Version 1.0
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("/resources")
    public String getTest() {
        return "this is common resource";
    }
}
