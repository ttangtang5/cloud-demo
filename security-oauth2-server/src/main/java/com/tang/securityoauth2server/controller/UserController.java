package com.tang.securityoauth2server.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author RLY
 * @Date 2019/6/27 10:34
 * @Version 1.0
 **/
@Controller
@RequestMapping("auth")
public class UserController {

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> getUserInfo(OAuth2Authentication user){
        Map<String, Object> map = new HashMap<>();

        map.put("userInfo", user.getUserAuthentication().getPrincipal());
        map.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));

        return map;
    }
}
