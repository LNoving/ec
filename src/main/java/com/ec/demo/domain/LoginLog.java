package com.ec.demo.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 张昊
 */
@Entity
@Table(name = "login_log")
public class LoginLog extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_log_id")
    private int loginLogId;

    @Column
    private Date lastLogin;

    @Column
    private Date lastLogout;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String ip;


    public int getLoginLogId() {
        return loginLogId;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(Date lastLogout) {
        this.lastLogout = lastLogout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
