package com.lk.test;

import java.sql.*;

public class Testjdbc2 {
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

        //3 编写SQL
        String sql = "insert into users(id, name, password, email, birthday) values (?,?,?,?,?)";

        //4 预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,5); //给第一个占位符?的值赋值为1
        preparedStatement.setString(2,"胡晓飞"); //给第二个占位符?的值赋值为胡晓飞
        preparedStatement.setString(3,"1234"); //给第三个占位符?的值赋值为1234
        preparedStatement.setString(4,"HUXIAOFEI@qq.com"); //给第四个占位符?的值赋值为...
        preparedStatement.setDate(5,new Date(new java.util.Date().getTime())); //给第五个占位符?的值赋值为
        //5 执行sql
        int i = preparedStatement.executeUpdate();
        if (i > 0 ){
            System.out.println("插入成功");
        }
        //6 关闭连接，释放资源 （原则——先开后关）
        preparedStatement.close();
        connection.close();

    }
}
