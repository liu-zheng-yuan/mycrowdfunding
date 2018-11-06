package com.nju.mycrowedfunding.controller;

import com.nju.mycrowdfunding.bean.AJAXResult;
import com.nju.mycrowdfunding.bean.User;
import com.nju.mycrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;

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
     * 执行登陆
     * */
    @ResponseBody
    @RequestMapping("/doAJAXLogin")
    public Object doAJAXLogin(User user){
        AJAXResult ajaxResult = new AJAXResult();
        //把表单数据封装为一个实体类User
        User dbUser=userService.query4Login(user);
        //判断用户是否存在
        if (dbUser != null){
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
