package com.lk.test;


import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Testdbc3 {
    @Test
    public void test()  {
        //获取配置信息
        //useUnicode = true &characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode = true  & useSSL = true";
        String username = "root";
        String password = "root";
        Connection connection = null;
        // 1加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");

        //2连接数据库  代表数据库
        connection = DriverManager.getConnection(url, username, password);
        //3 通知数据库开启事务 false 开启
        connection.setAutoCommit(false);
        String sql1 = "update account set money = money -100 where name = 'A'";
        connection.prepareStatement(sql1).executeUpdate();

        //制造错误
       // int i = 1/0;
        String sql2 = "update account set money = money +100 where name = 'B'";
        connection.prepareStatement(sql2).executeUpdate();

        connection.commit();  //以上两条SQL都执行成功了，就提交事务
        System.out.println("success");
    }catch (Exception e) {
            try {
            //如果出现异常，通知数据库回滚事务
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
    }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
