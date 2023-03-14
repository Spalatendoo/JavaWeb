package com.lk.service.user;

import com.lk.pojo.User;

public interface UserService {

    //用户登录
    public User login(String usercode,String password);


}
