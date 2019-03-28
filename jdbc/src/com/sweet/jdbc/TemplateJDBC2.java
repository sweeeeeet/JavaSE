package com.sweet.jdbc;

import jdk.internal.org.objectweb.asm.Handle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:sweet
 * Created:2019/3/25
 * <p>
 * 加载驱动、连接数据库、关闭资源为模板方法
 * 处理sql语句使用函数式接口：利用泛型传入一个值，返回另一个值
 * 执行sql语句通过参数传入sql命令，另一个参数为函数式接口处理语句结果
 */
public class TemplateJDBC2 {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
List<MemoGroup> list=new ArrayList<>();
    //1.加载驱动
    public void drive() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.连接数据库
    public void connect() {
        String url = "jdbc:mysql://127.0.0.1:3306/memo";

        try {
            connection = DriverManager.getConnection(url, "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.创建命令
    public void createStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //6.关闭资源
    private void close() {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public <T, R> T excute(String sql, HandlerRes<T, R> handle) {
        this.drive();
        this.connect();
        this.createStatement();
        //执行sql
        if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
            //如果是查询语句，则返回值是结果集
            try {
                resultSet = statement.executeQuery(sql);
//                handle方法入参为结果集，返回值为list
                return handle.handle((R) resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                Integer effect=statement.executeUpdate(sql);
                return handle.handle((R) effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.close();
        return null;
    }

    interface HandlerRes<T, R> {
        //传入值为R类型，返回值为T类型
        T handle(R r);
    }
}
