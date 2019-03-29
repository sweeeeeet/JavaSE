package com.sweet.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:sweet
 * Created:2019/3/26
 */
public class UseTempalte2 {
    public static void main(String[] args) throws SQLException {
TemplateJDBC2 test=new TemplateJDBC2();
String sql="insert into memo_group (id,name,created_time)  values(4,'go','2019-03-24 19:12:12')";
     sql="select id,name,created_time, modify_time from memo_group";
      ResultSet resultSet=  test.excute(sql, new TemplateJDBC2.HandlerRes<ResultSet, ResultSet>() {
          @Override
          public ResultSet handle(ResultSet resultSet) {
              return resultSet;
          }
      });
          List<MemoGroup> list=new ArrayList<>();

      while (resultSet.next()){
          MemoGroup memoGroup=new MemoGroup();
          memoGroup.setId(resultSet.getInt("id"));
          memoGroup.setName(resultSet.getString("name"));
          LocalDateTime create = resultSet.getTimestamp("created_time").toLocalDateTime();
          LocalDateTime modify = resultSet.getTimestamp("modify_time").toLocalDateTime();
          memoGroup.setCreatedTime(create);
          memoGroup.setModifyTime(modify);
          list.add(memoGroup);
      }
        System.out.println(list);
    }
}
