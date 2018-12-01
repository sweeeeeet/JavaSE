package com.practice1130.exceptions;

/**
 * Author:sweet
 * Created:2018/11/30
 */
public class StringTest {
    public static void main(String[] args) {
        String str="hello world";
        char cString=str.charAt(2);
        System.out.println(str+"的第二个字符是"+cString);
        System.out.println(str+"是否以he开头"+str.startsWith("he"));
        char[] chars={'a','c','d',};
        System.out.println(String.valueOf(chars));;
    }
}
