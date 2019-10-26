package com.dao;

import com.pojo.User;

public interface UserDao {
    public User login(User user);

    User register(String userId);
}
