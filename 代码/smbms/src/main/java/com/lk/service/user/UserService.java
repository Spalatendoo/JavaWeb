package com.lk.service.user;

import com.lk.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserService {

    //用户登录
    public User login(String usercode,String password);

    //根据用户ID修改密码
    public boolean updatePwd( int id, String password) ;

    //查询记录数
    public int getUserCount(String username,int userRole);

    //根据条件查询用户表
    public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo,int pagesize);




}
