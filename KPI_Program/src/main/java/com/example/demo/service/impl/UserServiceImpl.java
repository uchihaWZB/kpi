package com.example.demo.service.impl;

import com.example.demo.mapper.dao.UserDao;
import com.example.demo.model.UserPO;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zpmc on 2017/5/26.
 */

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public UserPO findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public List<UserPO> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserPO findUserByUsernameAndPassword(@Param("loginname") String loginname, @Param("password") String password) {

        return userDao.findUserByUsernameAndPassword(loginname,password);
    }
}
