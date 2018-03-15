package com.lzkydh.mapper;

import com.lzkydh.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lzk on 2018/3/10 14:52
 * Description:
 */
public interface UserMapper {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    public int deleteUserByUserId(Integer userId);

    /**
     * 根据用户id更新用户信息（邮箱，电话，用户名，地址）
     * @param user
     * @return
     */
    public int updateUserInfoByUserId(User user);

    /**
     * 根据用户id修改密码
     * @param userId
     * @param password
     * @return
     */
    public int updatePasswodByUserId(@Param(("userId")) Integer userId,@Param(("password")) String password);

    /**
     * 根据用户id查询用户信息（id，邮箱，电话，用户名，地址）
     * @param userId
     * @return
     */
    public User queryUserInfoByUserId(Integer userId);

    public String queryPasswordByUserId(Integer userId);

    public User queryUserInfoByPhoneOrEmail(String loginName);

    /**
     * 通过登录名（电话、邮箱）查询用户密码
     * @param loginName
     * @return
     */
    public String queryPasswordByPhoneOrEmail(String loginName);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryAll();


}
