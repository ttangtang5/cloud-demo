package com.tang.securityoauth2serverjwtcomplex.auth.config;

import com.tang.securityoauth2serverjwtcomplex.dao.LoginStatusRepository;
import com.tang.securityoauth2serverjwtcomplex.pojo.LoginStatus;
import com.tang.securityoauth2serverjwtcomplex.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 16:52
 * @Version 1.0
 **/
@Component
public class JwtTokenConverter extends JwtAccessTokenConverter {

    @Autowired
    private LoginStatusRepository loginStatusRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken oAuth2AccessToken = (DefaultOAuth2AccessToken) accessToken;
        User user = (User) authentication.getPrincipal();

        LoginStatus loginStatus = loginStatusRepository.findById(user.getId()).get();

        // 尽量请勿用此oAuth2AccessToken.getAdditionalInformation().put("customFiled", loginStatus.getSessionKey())操作，
        // 当原来没有附加信息时获取一个emptyMap是不可以操作，而抛出异常
        Map<String, Object> additionalMap = new HashMap<>();
        additionalMap.put("customFiled", loginStatus.getSessionKey());
        oAuth2AccessToken.setAdditionalInformation(additionalMap);

        return super.enhance(accessToken, authentication);
    }

}
