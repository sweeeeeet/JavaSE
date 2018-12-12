package com.sweet.generics;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class WildcardDown {
    public static void main(String[] args) {
        //在使用泛型的类的时候使用类的下限
        Message<? super String> message = new Message<>();
        message.setMess("hello");//可以设置属性内容
        message.getMess();//可以获取属性内容
    }
}


