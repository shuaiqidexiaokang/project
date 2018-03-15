package com.lzk.service.impl;

import com.lzk.mapper.UserMapper;
import com.lzk.model.User;
import com.lzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzk on 2018/3/1 14:08
 * Description:
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.queryById(username);
    }
}
