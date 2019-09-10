package com.tang.eurekaclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/17 16:34
 * @Version 1.0
 **/
@RequestMapping("test")
@RestController
public class TestController {

    @RequestMapping("/")
    public String test() {
        return "aaaaaaa";
    }
}
