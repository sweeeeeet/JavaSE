package com.sweet.printstream;

/**
 * Author:sweet
 * Created:2018/12/9
 */
public class FormatTest {

    public static void main(String[] args) {
        //printf为格式化输出
        //字符串：%s
        //整数：%d
        //浮点数：%f,  %.3f表示是含三位小数位的浮点数

//在格式前添加整数代表右对齐，添加负数代表左对齐
        System.out.printf("姓名：%4s,年龄：%-2d,身高：%.3f","长得三",23,1.83);
        System.out.printf("姓名：%4s,年龄：%-2d,身高：%.3f", "张三", 28, 168.7D);

        //利用String类的format方法，效果相同
        String str=String.format("姓名：%4s,年龄：%-2d,身高：%.3f", "张三", 28, 168.7D);
        System.out.println(str);
    }
}
