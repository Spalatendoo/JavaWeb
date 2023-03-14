package com.lk.service.user;

import com.lk.dao.BaseDao;
import com.lk.dao.User.UserDao;
import com.lk.dao.User.UserDaoimpl;
import com.lk.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    // 业务层都会调用dao层，所以我们要引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoimpl();
    }
    public User login(String usercode, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            // 通过业务层调用对应的具体的数据库操作
            user=userDao.getLoginUser(connection,usercode);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
    return user;
    }
/*    @Test
    public void test(){
        UserServiceImpl userServiceimpl = new UserServiceImpl();
        User admin = userServiceimpl.login("admin","1234567");
        System.out.println(admin.getUserPassword());
    }*/


}
