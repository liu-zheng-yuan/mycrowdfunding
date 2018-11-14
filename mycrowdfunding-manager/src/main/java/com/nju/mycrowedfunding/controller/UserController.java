package com.nju.mycrowedfunding.controller;

import com.nju.mycrowedfunding.bean.User;
import com.nju.mycrowedfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    /*
    * 用户首页
    * */
    @RequestMapping("/index")
    public String index(@RequestParam(required = false,defaultValue = "1") Integer pageNumber, @RequestParam(required = false,defaultValue = "2")Integer pageSize, Model model){
        //分页查询用户
        //limit 起始位置，size
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("start",(pageNumber-1) * pageSize);//计算起始位置
        map.put("size",pageSize);
        List<User> users = userService.pageQueryData(map);
        //放入model中 就是放入到request域中
        model.addAttribute("users",users);
        //当前页码
        model.addAttribute("pageNumber", pageNumber);
        //最大页码
        int totalNumber = userService.pageQueryCount(map);
        int totalPages = totalNumber % pageSize == 0 ? totalNumber / pageSize : (totalNumber / pageSize + 1);
        model.addAttribute("totalPages",totalPages);

        return "user/index";
    }
}
