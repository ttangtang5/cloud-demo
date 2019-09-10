package com.tang.securityoauth2serverjwtcomplex.dao;

import com.tang.securityoauth2serverjwtcomplex.pojo.LoginStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 17:05
 * @Version 1.0
 **/
public interface LoginStatusRepository extends JpaRepository<LoginStatus, Long> {


}
