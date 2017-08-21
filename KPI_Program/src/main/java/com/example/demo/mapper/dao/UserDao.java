package com.example.demo.mapper.dao;

import com.example.demo.model.UserPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * User DAO 接口类
 * Created by zpmc on 2017/5/25.
 */

@Mapper
public interface UserDao {

    /**
     * 获得所有的User
     * @return
     */
    @Select("SELECT * FROM USERS")
    List<UserPO> getAllUsers();

    /**
     * 根据id查询UserPO
     * @param userid    用户id
     *
     * @return UserPO
     */
    @Select("SELECT * FROM USERS WHERE USERID = #{userid}")
    UserPO findUserById(@Param("userid") Integer userid);

    /**
     * 根据登录名loginname，查询UserPO
     *@param name
     */
    @Select("select * from users where username = #{username}")
    UserPO findUserByName(@Param("name") String name);

    /**
     * 根据登录名loginname，密码password，查询用户进行登录
     * @param loginname 登录名
     * @param password  密码
     */
    @Select("SELECT * FROM KPI_USERS WHERE LOGINNAME = #{loginname} AND PASSWORD = #{password}")
    UserPO findUserByUsernameAndPassword(@Param("loginname") String loginname,
                                         @Param("password") String password);
}
