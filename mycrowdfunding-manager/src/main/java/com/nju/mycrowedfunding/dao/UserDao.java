package com.nju.mycrowedfunding.dao;

import com.nju.mycrowedfunding.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {

    @Select("select * from t_user")
    List<User> queryAll();

    @Select("select * from t_user where loginacct = #{loginacct} and userpswd = #{userpswd}")
    User query4Login(User user);


    List<User> pageQueryData(Map<String, Integer> map);

    int pageQueryCount(Map<String, Integer> map);
}
