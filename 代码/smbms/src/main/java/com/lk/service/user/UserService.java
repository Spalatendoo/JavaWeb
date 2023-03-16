package com.lk.service.user;

import com.lk.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserService {

    //用户登录
    public User login(String usercode,String password);

    //根据用户ID修改密码
    public boolean updatePwd( int id, String password) ;

}
