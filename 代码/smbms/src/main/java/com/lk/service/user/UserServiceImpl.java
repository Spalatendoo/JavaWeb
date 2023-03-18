package com.lk.service.user;

import com.lk.dao.BaseDao;
import com.lk.dao.User.UserDao;
import com.lk.dao.User.UserDaoimpl;
import com.lk.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    public boolean updatePwd(int id, String password)  {

        System.out.println("UserService" + password);
        Connection connection = null;
        boolean flag = false;
        connection = BaseDao.getConnection();

        //修改密码
        try {
            if (userDao.updatePwd(connection,id,password)>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return flag;
    }

    //查询记录数
    public int getUserCount(String username,int userRole){
        Connection connection = null;
        int count = 0;

        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, username, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null,null );
        }
        return count;
    }

/*
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount = userService.getUserCount(null,1);
        System.out.println(userCount);
    }
 */

//根据条件查询用户表
    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pagesize) {
        Connection connection = null;
        List<User> userList = null;

        System.out.println("queryUserName ------>" + queryUserName);
        System.out.println("queryUserRole ------>" + queryUserRole);
        System.out.println("currentPageNo ------>" + currentPageNo);
        System.out.println("pagesize ------>" + pagesize);

        connection = BaseDao.getConnection();
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pagesize);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return userList;
    }
}
