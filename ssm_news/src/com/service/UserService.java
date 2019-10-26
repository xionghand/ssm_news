package com.service;

import com.pojo.User;

import java.util.List;

public interface UserService {
    /*
     *  登录功能
     * */
    public User login(User user);
    /*
     *   显示列表
     * */
    public List<User> queryAll();

    /*
     *  根据userId修改修记录
     * */
    public User queryByUserId(String userId);

    public int updateUser(User user);

    /*
     * 根据userId删除数据
     * */
    public int delUser(String userId);

    /*
     *   插入数据
     * */
    public int insertUser(User user);

    /*
    *   注册
    * */
    public User register(String userId);

}
