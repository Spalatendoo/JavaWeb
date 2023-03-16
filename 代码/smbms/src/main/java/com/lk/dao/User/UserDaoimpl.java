package com.lk.dao.User;

import com.lk.dao.BaseDao;
import com.lk.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoimpl implements UserDao {

    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};


            rs = BaseDao.execute(connection, sql, params, rs, pstm);

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getDate("creationDate"));
                user.setModifyBy(rs.getInt("creationDate"));
                user.setModifyDate(rs.getDate("modifyDate"));

            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return user;
    }

    //修改当前用户密码

    public  int updatePwd(Connection connection, int id, String password) throws SQLException{
        System.out.println("UserDao" + password);
        PreparedStatement pstm = null;
        int execute = 0;
        if (connection != null){
            System.out.println(execute);
            String sql = "update smbms_user set userPassword =? where id =?";
            Object params[] = {password,id};
            execute = BaseDao.execute(connection, pstm,sql, params);
           // System.out.println(execute);
            BaseDao.closeResource(null,pstm,null);
        }
        return execute;

    }
}