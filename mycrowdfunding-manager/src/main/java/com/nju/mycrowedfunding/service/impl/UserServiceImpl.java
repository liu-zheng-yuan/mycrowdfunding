package com.nju.mycrowedfunding.service.impl;

import com.nju.mycrowedfunding.bean.User;
import com.nju.mycrowedfunding.dao.UserDao;
import com.nju.mycrowedfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<User> pageQueryData(Map<String, Integer> map) {
        return userDao.pageQueryData(map);
    }

    public int pageQueryCount(Map<String, Integer> map) {
        return userDao.pageQueryCount(map);
    }

}
