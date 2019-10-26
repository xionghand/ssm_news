package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Override
    public User login(User user) {
//        if(user.getUserId()!=null && !user.getUserId().equals("") && user.getPassword()!=null && !user.getPassword().equals("")){
//            return userDao.login(user);
//        }
//        return null;



        User user1 = userDao.login(user);
//        sqlSession.close();
        return user1;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public User queryByUserId(String userId) {
        return null;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int delUser(String userId) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public User register(String userId) {

        User user1 = userDao.register(userId);

        return user1;
    }
}
