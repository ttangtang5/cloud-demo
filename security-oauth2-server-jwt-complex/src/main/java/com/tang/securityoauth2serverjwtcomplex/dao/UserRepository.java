package com.tang.securityoauth2serverjwtcomplex.dao;

import com.tang.securityoauth2serverjwtcomplex.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 15:33
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
