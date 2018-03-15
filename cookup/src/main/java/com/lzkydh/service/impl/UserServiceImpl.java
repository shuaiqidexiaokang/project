package com.lzkydh.service.impl;

import com.lzkydh.mapper.UserMapper;
import com.lzkydh.model.User;
import com.lzkydh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserByUserId(Integer userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Override
    public int updateUserInfoByUserId(User user) {
        return userMapper.updateUserInfoByUserId(user);
    }

    @Override
    public int updatePasswodByUserId(Integer userId, String password) {
        return userMapper.updatePasswodByUserId(userId,password);
    }

    @Override
    public User queryUserInfoByUserId(Integer userId) {
        return userMapper.queryUserInfoByUserId(userId);
    }

    @Override
    public String queryPasswordByUserId(Integer userId) {
        return userMapper.queryPasswordByUserId(userId);
    }

    @Override
    public User queryUserInfoByPhoneOrEmail(String loginName) {
        return userMapper.queryUserInfoByPhoneOrEmail(loginName);
    }

    @Override
    public String queryPasswordByPhoneOrEmail(String loginName) {
        return userMapper.queryPasswordByPhoneOrEmail(loginName);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
