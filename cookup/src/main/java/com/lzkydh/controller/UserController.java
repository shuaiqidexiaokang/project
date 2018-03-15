package com.lzkydh.controller;

import com.lzkydh.dto.Result;
import com.lzkydh.model.User;
import com.lzkydh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录接口
     * @param loginName 用户名（手机号或邮箱）
     * @param password 密码
     * @param request
     * @return
     */
    @GetMapping("/login")
    public Result<User> login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, HttpServletRequest request) {
        User user = userService.queryUserInfoByPhoneOrEmail(loginName);
        if (user != null) {
            String truePassword = userService.queryPasswordByPhoneOrEmail(loginName);
            if (truePassword.equals(password)){
                request.getSession().setAttribute("user",user);
                return new Result<>(true, user, "登录成功");
            } else {
                return new Result<>(false, "密码错误");
            }
        } else {
            return new Result<>(false, "用户名不存在");
        }
    }

    /*
    * @RequestBody 用于接收json串  如ajax请求的data参数    可在直接接收转换到Pojo
      @ModelAttribute 用于直接接受url?后面的参数 如url?id=123&name=456 可在直接接收转换到Pojo
      @Valid表单校验
    * */

    /**
     * 注册--添加用户信息
     * @param user 用户信息
     * @return
     */
    @PostMapping("/register")
    public Result<User> register(User user) {
        int count = userService.addUser(user);
        if ( count == 0) {
            return new Result<>(false, "邮箱或电话已注册");
        } else {
            return new Result<>(true, "注册成功");
        }
    }

    /**
     * 注销--移除session中user记录
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return new Result(true,"注销成功");
    }

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    @PostMapping("/{userId}/delete")
    public Result delete(@PathVariable("userId") Integer userId) {
        int count = userService.deleteUserByUserId(userId);
        if (count > 0){
            return new Result(true,"删除成功");
        }
        return new Result(false,"删除失败");
    }

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/info/edit")
    public Result editUserInfo(User user) {
        User user1 = userService.queryUserInfoByPhoneOrEmail(user.getEmail());
        User user2 = userService.queryUserInfoByPhoneOrEmail(user.getPhone());
        if (user1 != null || user2 !=null){
            return new Result(true,"修改用户信息失败，用户名已存在");
        }else{
            int count = userService.updateUserInfoByUserId(user);
            if (count > 0){
                return new Result(true,"修改用户信息成功");
            }
            return new Result(false,"修改用户信息失败");
        }
    }

    /**
     * 根据用户id修改用户密码
     * @param userId
     * @param password
     * @return
     */
    @PostMapping("/password/edit")
    public Result editPassword(@RequestParam("userId") Integer userId,@RequestParam("password") String password) {
        int count = userService.updatePasswodByUserId(userId,password);
        if (count > 0){
            return new Result(true,"修改用户密码成功");
        }
        return new Result(false,"修改用户密码失败");
    }

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public Result<User> queryUserInfo(@PathVariable("userId") Integer userId) {
        User user = userService.queryUserInfoByUserId(userId);
        if (user !=null){
            return new Result(true,user,"查询用户信息成功");
        }
        return new Result(false,"查询用户信息失败");
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @GetMapping("/")
    public Result<List<User>> queryAll() {
        List<User> users = userService.queryAll();
        if (users !=null){
            return new Result(true,users,"查询所有用户信息成功");
        }
        return new Result(false,"查询所有用户信息失败");
    }
}
