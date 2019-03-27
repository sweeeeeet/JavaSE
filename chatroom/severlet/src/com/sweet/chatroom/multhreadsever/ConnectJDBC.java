package com.sweet.chatroom.multhreadsever;

import java.sql.*;

/**
 * Author:sweet
 * Created:2019/3/26
 */
public class ConnectJDBC {

        private Connection connection = null;
        private PreparedStatement statement=null;
        private ResultSet resultSet = null;

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

        //3.创建预编译命令
        public void createStatement(String sql) {
            try {
                statement = connection.prepareStatement(sql);
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

        public <T, R> T excute(String sql, String[] args,HandlerRes<T, R> handle) {
            this.drive();
            this.connect();
            //执行命令，可以使用占位符
            this.createStatement(sql);
            for(int i=0;i<args.length;i++){
                try {
                    //通过反射的方式为参数赋值
                    this.statement.setString(i+1,args[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            //执行sql
            if (sql.trim().startsWith("select") || sql.trim().startsWith("SELECT")) {
                //如果是查询语句，则返回值是结果集
                try {

                    //预编译指令执行结果时不需要在此方法上传入参数，而Stament类需要传入参数
                    resultSet = statement.executeQuery();
//                handle方法入参为结果集，返回值为list
                    return  handle.handle((R) resultSet);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Integer effect=  statement.executeUpdate();
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
//        public List<MemoGroup> collectResult(ResultSet resultSet) throws SQLException {
//
//            while (resultSet.next()){
//                MemoGroup memoGroup=new MemoGroup();
//                memoGroup.setId(resultSet.getInt("id"));
//                memoGroup.setName(resultSet.getString("name"));
//                LocalDateTime create = resultSet.getTimestamp("created_time").toLocalDateTime();
//                LocalDateTime modify = resultSet.getTimestamp("modify_time").toLocalDateTime();
//                memoGroup.setCreatedTime(create);
//                memoGroup.setModifyTime(modify);
//                list.add(memoGroup);
//            }
//            return list;
//        }
    }


