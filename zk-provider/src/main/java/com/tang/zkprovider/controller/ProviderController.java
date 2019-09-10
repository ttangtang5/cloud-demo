package com.tang.zkprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/5/27 9:18
 * @Version 1.0
 **/
@RestController
@RequestMapping("provider")
public class ProviderController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(String name) {
        return "hello" + name;
    }

}
