package com.tang.securityoauth2serverjwtcomplex.auth.config;

import com.tang.securityoauth2serverjwtcomplex.dao.UserRepository;
import com.tang.securityoauth2serverjwtcomplex.pojo.Role;
import com.tang.securityoauth2serverjwtcomplex.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 16:05
 * @Version 1.0
 **/
@Service
public class BaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 这里可以处理user和role  也可以通过调用其他服务获取信息
        User user = userRepository.findUserByUsername(s);
        //Role role = new Role();
        //role.setId(1L);
        //role.setName("user");
        //user.setAuthorities(Collections.singletonList(role));
        return user;
    }

}
