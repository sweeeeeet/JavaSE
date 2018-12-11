package com.sweet;

import java.util.Calendar;
import java.util.Date;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
    //从calendar对象中取出Date对象
        Date date = calendar.getTime();
        //通过Date对象获得对应的Calendar对象
        //Calendar没有相应的构造函数接收Date对象
        //所有通过setTime方法接收
        Calendar calendar2 = Calendar.getInstance();

        calendar2.setTime(date);
        System.out.println(calendar2);
        System.out.println(date);
    }
}
