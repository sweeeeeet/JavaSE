package com.sweet.jdbc;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Author:sweet
 * Created:2019/3/24
 */
public class JdbcTest {
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
            String sql = "select id,name,created_time, modify_time from memo_group";
            resultSet = statement.executeQuery(sql);
            //String sql1="insert into memo_group(id,name) values(2,'java',2019-03-25 16:12:12 )";
           // statement.executeUpdate(sql1);
            //5.处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime creat_time = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modify_time = resultSet.getTimestamp("modify_time").toLocalDateTime();
                System.out.println(String.format("编号：%d 名称：%s 创建时间：%s 修改时间：%s", id, name, creat_time, modify_time));
            }
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
