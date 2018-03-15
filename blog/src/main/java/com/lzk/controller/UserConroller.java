package com.lzk.controller;


import com.lzk.dto.Result;
import com.lzk.model.User;
import com.lzk.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lzk on 2018/3/1 13:54
 * Description:
 */
@Controller
/*@SessionAttributes(value = "username",types = String.class)*/
//不知道为什么清除不了session
@RequestMapping("/user")
public class UserConroller {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

     /*   *
         * 处理用户登录
         * @param loginUser
         * @param model
         * @return
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User loginUser, Model model){
        String msg = "";
        if (loginUser !=null){
            String username = loginUser.getUsername();
            User user = userService.findUserByUsername(username);
            if (user!=null){
                if (user.getPassword().equals(loginUser.getPassword())){
                    model.addAttribute("username",username);
                    return "redirect:/article/list";
                }
                else
                    msg="密码错误";
            }else{
                msg="用户名不存在";
            }
        }
        model.addAttribute("msg",msg);
        //转发到login页面url地址由http://localhost:8080/blog/user/login -->>
        //http://localhost:8080/blog/user/login
        return "admin/login";
    }

    /**
     * 通过ajax方法处理登录
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/login1",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<User> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){
        if (username==null||username.length()==0){
            return new Result<User>(false,"请输入用户名");
        }else{
            if (password==null||password.length()==0){
                return new Result<User>(false,"请输入密码");
            }else{
                User user = userService.findUserByUsername(username);
                if (user!=null){
                    if (user.getPassword().equals(password)){
                        request.getSession().setAttribute("username",username);
                        return new Result<User>(true,user,"登录成功");
                    }else{
                        return new Result<User>(false,"密码错误");
                    }
                }else{
                    return new Result<User>(false,"用户名不存在");
                }
            }
        }
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("username");
        return "admin/login1";
    }

}
