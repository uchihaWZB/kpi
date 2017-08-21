package com.example.demo.service;

import com.example.demo.model.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zpmc on 2017/5/26.
 */
public interface UserService {

    /**
     * 根据姓名查询user
     *@param name
     */
    UserPO findUserByName(String name);

    /**
     * 获得所有的User
     * @return
     */
    List<UserPO> getAllUsers();

    /**
     * 根据登录名loginname，密码password，查询用户进行登录
     * @param loginname 登录名
     * @param password  密码
     */
    UserPO findUserByUsernameAndPassword(@Param("loginname") String loginname,
                                         @Param("password") String password);
}
