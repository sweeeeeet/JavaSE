package com.sweet.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:sweet
 * Created:2019/3/25
 */
public class UseTemplate extends Templatejdbc {
    @Override
    public String provideSql() {
        //  return "insert into memo_group (id,name,created_time)  values(3,'php','2019-03-15 19:12:12')";
        return "select id,name,created_time, modify_time from memo_group";
    }

    @Override
    public <T> T handle(ResultSet resultSet) {
        List<MemoGroup> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime create = resultSet.getTimestamp("created_time").toLocalDateTime();
                LocalDateTime modify = resultSet.getTimestamp("modify_time").toLocalDateTime();
                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(id);
                memoGroup.setName(name);
                memoGroup.setCreatedTime(create);
                memoGroup.setModifyTime(modify);
                list.add(memoGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) list;
    }

    public static void main(String[] args) {
        UseTemplate useTemplate = new UseTemplate();
        List<MemoGroup> list = useTemplate.excute();
        for (MemoGroup m : list) {
            System.out.println(m);
        }
    }
}
