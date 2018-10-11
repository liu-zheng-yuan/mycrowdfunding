package com.nju.mycrowdfunding.service;

import com.nju.mycrowdfunding.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryAll();

    User query4Login(User user);
}
