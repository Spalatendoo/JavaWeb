package com.lk.test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取配置信息
        //useUnicode = true &characterEncoding=utf-8 解决中文乱码
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode = true  & useSSL = true";
        String username = "root";
        String password = "root";

        // 1加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2连接数据库  代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3像数据库发送SQL的对象Statement
        Statement statement = connection.createStatement();

        //4 编写SQL
        String sql = "select * from users";

        //5 执行查询SQL 返回一个ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id = " + resultSet.getObject("id"));
            System.out.println("name = " + resultSet.getObject("name"));
            System.out.println("password = " + resultSet.getObject("password"));
            System.out.println("email = " + resultSet.getObject("email"));
            System.out.println("birthday = " + resultSet.getObject("birthday"));
        }

        //6 关闭连接，释放资源 （原则——先开后关）
        resultSet.close();
        statement.close();
        connection.close();

    }
}
