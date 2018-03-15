package com.lzk.service;

import com.lzk.mapper.UserMapper;
import com.lzk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lzk on 2018/3/1 14:07
 * Description:
 */
public interface UserService {

    User findUserByUsername(String username);

}
