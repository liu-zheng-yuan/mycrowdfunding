package com.nju.mycrowdfunding.service.impl;

import com.nju.mycrowdfunding.bean.User;
import com.nju.mycrowdfunding.dao.UserDao;
import com.nju.mycrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAll() {
        return userDao.queryAll();
    }

    public User query4Login(User user) {
        return userDao.query4Login(user);
    }
}
