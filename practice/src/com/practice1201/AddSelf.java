package com.practice1201;

/**
 * Author:sweet
 * Created:2018/12/1
 */
public class AddSelf {
    public static void main(String[] args) {
        int i=12;
        int j;
        j=++i;
        System.out.println("++i对j赋值"+j);//13
        i=++i;
        System.out.println("++i对i赋值"+i);//13
        i=i++;
        System.out.println("i++对i赋值"+i);//12
        j=i++;
        System.out.println("i++对j赋值"+j);//12
    }
}
