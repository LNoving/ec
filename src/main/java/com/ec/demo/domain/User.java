package com.ec.demo.domain;

import org.aspectj.weaver.ast.Or;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 张昊
 */
@Entity
@Table(name = "user")
public class User extends BaseDomain{
    /**
     * 用户类型
     */
    public static final int USER_BUYER = 0;
    public static final int USER_SELLER = 1;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type")
    private int userType;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL)
    private Set<Order> buyOrder = new HashSet<>();

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private Set<Order> sellOrder = new HashSet<>();

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    private Set<Commodity> commodity = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Demand> demands = new HashSet<>();

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Order> getBuyOrder() {
        return buyOrder;
    }

    public void setBuyOrder(Set<Order> buyOrder) {
        this.buyOrder = buyOrder;
    }

    public Set<Order> getSellOrder() {
        return sellOrder;
    }

    public void setSellOrder(Set<Order> sellOrder) {
        this.sellOrder = sellOrder;
    }

    public Set<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(Set<Commodity> commodity) {
        this.commodity = commodity;
    }
}
