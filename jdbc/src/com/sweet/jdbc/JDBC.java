package com.sweet.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:sweet
 * Created:2019/4/29
 */
public class JDBC {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接
            String url = "jdbc:mysql://127.0.0.1:3306/test";
            connection = DriverManager.getConnection(url, "root", "000000");
            //3.创建操作命令
            statement = connection.createStatement();
            //4.执行sql语句
            String sql = "create table student(name varchar(20)  primary key ,age int,birth int);";
            statement.executeQuery(sql);
            sql = "insert into student (name,age,birth) values('张三',12,19980912);";
            statement.executeQuery(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();

                }
                if (connection != null) {
                    connection.close();

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

