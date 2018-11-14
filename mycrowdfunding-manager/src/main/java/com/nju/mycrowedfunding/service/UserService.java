package com.nju.mycrowedfunding.service;

import com.nju.mycrowedfunding.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryAll();

    User query4Login(User user);

    List<User> pageQueryData(Map<String, Integer> map);

    int pageQueryCount(Map<String, Integer> map);
}
