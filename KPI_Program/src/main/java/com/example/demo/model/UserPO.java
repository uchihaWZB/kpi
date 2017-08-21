package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovopc001 on 2017/7/10.
 */

@Entity
@Table(name = "kpi_users")
public class UserPO implements Serializable {

    //用户主键id
    private Integer userId;

    //用户名
    private  String username;

    //用户登录名
    private String loginname;

    //用户登录密码
    private String password;

    //用户登录状态
    private Integer status;

    //用户创建日期
    private Date created;

    //用户更新日期
    private Date updated;

    public UserPO() {}

    public UserPO(Integer userId, String username, String loginname, String password, Integer status, Date created, Date updated) {
        this.userId = userId;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    @Id
    @GeneratedValue
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date createDate) {
        this.created = createDate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
