package com.lk.dao.User;

import com.lk.dao.BaseDao;
import com.lk.pojo.Role;
import com.lk.pojo.User;
import com.mysql.jdbc.StringUtils;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
//根据用户名喝角色查询用户整数
    public int getUserCount(Connection connection,String username,int userRole)throws SQLException{
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        if (connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u ,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();//存放参数

            if (!StringUtils.isNullOrEmpty(username)){
                sql.append(" and u.username like ?");
                list.add("%"+username+"%"); //index: 0

            }

            if (userRole > 0 ){
                sql.append(" and u.userRole = ?");
                list.add(userRole);  //index:1
            }
            //把list转换为数组
            Object[] params = list.toArray();
            System.out.println("UserDaoImpl -> getUserCount " + sql.toString());   //输出最后完整的sql语句

            rs  = BaseDao.execute(connection, sql.toString(), params, rs, pstm);
            if (rs.next()){
                count = rs.getInt("count");  //从结果集中获取最终的数量
            }
            BaseDao.closeResource(null,pstm,rs);

        }
    return count;
    }


    //获取用户列表
    @Override
    public List<User> getUserList(Connection connection, String username, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if (connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u ,smbms_role r where u.userRole=r.id");
            ArrayList<Object> list = new ArrayList<>();  //存放参数
            if (! StringUtils.isNullOrEmpty(username)) {
                sql.append(" and u.userName like ?");
                list.add("%" + username + "%");
            }
            if (userRole >0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            // 在Mysql数据库中，分页使用 limit startIndex pageSize; 总数
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo - 1) * pageSize;

            list.add(currentPageNo);
            list.add(pageSize) ;

            Object[] params = list.toArray();

            rs = BaseDao.execute(connection, sql.toString(), params, rs, pstm);

            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setUserRole(rs.getInt("userRole"));
                user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(user);
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return userList;
    }




}