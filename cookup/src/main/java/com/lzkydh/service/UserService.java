package com.lzkydh.service;

import com.lzkydh.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    //根据用户id查询用户
    int deleteUserByUserId(Integer userId);

    //根据用户id修改用户信息
    int updateUserInfoByUserId(User user);

    //根据用户id修改用户密码
    int updatePasswodByUserId(Integer userId,String password);

    //根据用户id查询用户信息
    User queryUserInfoByUserId(Integer userId);

    //根据用户id查询用户密码
    String queryPasswordByUserId(Integer userId);

    //根据用户名查询用户信息
    User queryUserInfoByPhoneOrEmail(String loginName);

    //根据用户名查询密码
    String queryPasswordByPhoneOrEmail(String loginName);

    //查询所有用户信息
    List<User> queryAll();
}
