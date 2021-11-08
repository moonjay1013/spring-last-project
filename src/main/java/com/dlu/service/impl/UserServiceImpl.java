package com.dlu.service.impl;

import com.dlu.dao.UserDao;
import com.dlu.pojo.User;
import com.dlu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findUser(String name,String pwd) {
        return userDao.findUserByNameAndPwd(name,pwd);
    }
}
