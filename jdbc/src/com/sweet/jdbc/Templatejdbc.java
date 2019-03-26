package com.sweet.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:sweet
 * Created:2019/3/25
 * 使用模板设计模式实现JDBC
 */

public abstract class Templatejdbc {


    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    //1.加载驱动
    public void drive(String drive) {
        if (drive == null) {
            drive = "com.mysql.jdbc.Driver";
        }
        try {
            Class.forName(drive);
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

    //4.执行sql
    //空实现
    public <T> T handle(ResultSet resultSet) throws SQLException {
        return null;
    }

    public <T> T handle(int effect) {
        return null;
    }

//    public int handle(String sql) {
//        int effect = -1;
//        try {
//            effect = statement.executeUpdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return effect;
//    }

//    public ResultSet handle(String sql) {
//
//        try {
//            resultSet = statement.executeQuery(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultSet;
//    }

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

    //返回值为泛型，因此最终返回handle方法
    public final <T> T excute() {
        this.drive(null);
        this.connect();
        this.createStatement();
        if (this.provideSql().trim().startsWith("select") || this.provideSql().trim().startsWith("SELECT")) {
            try {
                resultSet = this.statement.executeQuery(this.provideSql());
                return handle(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {

            try {
                Integer effect = this.statement.executeUpdate(this.provideSql());
                return this.handle(effect);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public abstract String provideSql();
}



