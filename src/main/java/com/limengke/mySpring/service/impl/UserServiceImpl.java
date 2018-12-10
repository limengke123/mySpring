package com.limengke.mySpring.service.impl;

import com.limengke.mySpring.dao.UserDao;
import com.limengke.mySpring.model.User;
import com.limengke.mySpring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

}
