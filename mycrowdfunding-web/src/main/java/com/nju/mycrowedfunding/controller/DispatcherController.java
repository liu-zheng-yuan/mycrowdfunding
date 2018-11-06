package com.nju.mycrowedfunding.controller;

import com.nju.mycrowdfunding.bean.AJAXResult;
import com.nju.mycrowdfunding.bean.User;
import com.nju.mycrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class DispatcherController {

    @Autowired
    UserService userService;

    /*
    * 登陆页面
    * */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    /*
    * 登出页面
    * */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //删除session中的所有登陆信息 不需要一个个删除
        //session.removeAttribute("loginUser");
        session.invalidate();
        //希望浏览器显示地址为主页 就需要重定向
        return "redirect:login";
    }
    /*
     * 执行登陆
     * */
    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user, HttpSession session){
        AJAXResult ajaxResult = new AJAXResult();
        //把表单数据封装为一个实体类User
        User dbUser=userService.query4Login(user);
        //判断用户是否存在
        if (dbUser != null){
            //储存在会话域里
            session.setAttribute("loginUser",dbUser);
            ajaxResult.setSuccess(true);
        }else{
            ajaxResult.setSuccess(false);
        }

        return ajaxResult;
    }

    /*
    * 跳转主页面
    * */
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
