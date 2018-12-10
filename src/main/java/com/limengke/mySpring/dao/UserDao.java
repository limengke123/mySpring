package com.limengke.mySpring.dao;

import com.limengke.mySpring.model.User;

public interface UserDao {
    User selectUser (long id);
}
