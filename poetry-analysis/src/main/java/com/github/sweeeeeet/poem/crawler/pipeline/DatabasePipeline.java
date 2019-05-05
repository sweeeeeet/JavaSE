package com.github.sweeeeeet.poem.crawler.pipeline;

import com.github.sweeeeeet.poem.crawler.common.Page;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Author:sweet
 * Created:2019/4/26
 */
public class DatabasePipeline implements Pipeline {

    private final DataSource dataSource;

    public DatabasePipeline(DataSource  dataSource) {

        this.dataSource=dataSource;
    }

    @Override
    public void pipeline(Page page) {

     String dynasty=(String) page.getDataSet().getData("dynasty");
     String author=(String) page.getDataSet().getData("author");
     String title=(String) page.getDataSet().getData("title");
     String content=(String) page.getDataSet().getData("content");


         //可以继续修改对象
        page.getDataSet().putData("url",page.getUrl());




     String sql="insert into poem_info (title, dynasty, author, content) values (?,?,?,?);";
        try (
            Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)
        ){
            statement.setString(1,title);
            statement.setString(2,dynasty);
            statement.setString(3,author);
            statement.setString(4,content);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
