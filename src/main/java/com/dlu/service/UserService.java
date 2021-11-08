package com.dlu.service;

import com.dlu.pojo.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);

    List<User> findAll();

    User findUser(String name,String pwd);
}
