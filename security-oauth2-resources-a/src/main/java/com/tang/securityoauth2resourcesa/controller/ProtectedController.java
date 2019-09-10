package com.tang.securityoauth2resourcesa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/28 15:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("protected")
public class ProtectedController {

    @RequestMapping("/resources")
    public String getResources() {
        return "admin resources";
    }
}
