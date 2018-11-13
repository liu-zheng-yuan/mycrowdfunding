package com.nju.mycrowedfunding.service;

import com.nju.mycrowedfunding.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    User query4Login(User user);
}
