package com.sweet.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:sweet
 * Created:2019/3/24
 */
public class JdbcTestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接
            String url="jdbc:mysql://127.0.0.1:3306/memo";
            connection = DriverManager.getConnection(url,"root","123456");
            //3.创建操作命令
            statement = connection.createStatement();
            //4.执行sql语句
            String sql = "insert into memo_group (id,name,created_time)  values(2,'java','2019-03-25 19:12:12')";
            //5.处理结果集
            int effect=statement.executeUpdate(sql);
            System.out.println("影响行数"+effect);

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
