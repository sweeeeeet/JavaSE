package com.sweet.jdbc;

import java.sql.ResultSet;
import java.util.List;

/**
 * Author:sweet
 * Created:2019/3/26
 */
public class UseTemplate3 {
    public static TemplateJDBC3 test = new TemplateJDBC3();

    public static void quiryByName(String name) {
        String sql = "select id ,name,created_time, modify_time  from memo_group  where name in (?)";
        List<MemoGroup> memoGroups = test.excute(sql, new String[]{name},(List<MemoGroup> list)->list) ;
        for(MemoGroup memoGroup:memoGroups){
            System.out.println(memoGroup);
        }
    }


    public static void main(String[] args) {
        quiryByName("java");
    }
}
