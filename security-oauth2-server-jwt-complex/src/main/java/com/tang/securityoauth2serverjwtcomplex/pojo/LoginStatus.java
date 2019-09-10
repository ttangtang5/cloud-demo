package com.tang.securityoauth2serverjwtcomplex.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Description
 * @Author RLY
 * @Date 2019/7/2 16:59
 * @Version 1.0
 **/
@Entity(name = "login_status")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginStatus {

    @Id
    private long id;

    private String sessionKey;

    @CreationTimestamp
    private Date loginTime;

    @Column(name = "timeout")
    private long timeOut;
}
