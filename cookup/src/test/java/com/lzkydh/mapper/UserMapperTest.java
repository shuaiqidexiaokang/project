package com.lzkydh.mapper;

import com.lzkydh.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void addUser() throws Exception {
        // String email, String phone, String password, String username, String address) {
        User user = new User("eee","777","123","yaya","7777");
        int count = userMapper.addUser(user);
        System.out.println(count);
    }

    @Test
    public void deleteUserByUserId() throws Exception {
        int count = userMapper.deleteUserByUserId(1004);
        System.out.println(count);
    }

    @Test
    public void updateUserInfoByUserId() throws Exception {
        User user = userMapper.queryUserInfoByUserId(1006);
        user.setEmail("fff");
        int count = userMapper.updateUserInfoByUserId(user);
        System.out.println(count);
    }

    @Test
    public void updatePasswodByUserId() throws Exception {
        int count = userMapper.updatePasswodByUserId(1006,"123");
        System.out.println(count);
    }

    @Test
    public void queryUserInfoByUserId() throws Exception {
        User user = userMapper.queryUserInfoByUserId(1000);
        System.out.println(user);
    }

    @Test
    public void queryPasswordByUserId() throws Exception {
        String password = userMapper.queryPasswordByUserId(1000);
        System.out.println(password);
    }


    @Test
    public void queryUserInfoByPhoneOrEmail() throws Exception {
        User user = userMapper.queryUserInfoByPhoneOrEmail("aaa");
        System.out.println(user);
    }

    @Test
    public void queryPasswordByPhoneOrEmail() throws Exception {
        String password = userMapper.queryPasswordByPhoneOrEmail("aaa");
        System.out.println(password);
    }
}