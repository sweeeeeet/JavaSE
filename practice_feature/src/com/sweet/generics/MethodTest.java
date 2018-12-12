package com.sweet.generics;

/**
 * Author:sweet
 * Created:2018/12/10
 */
public class MethodTest<T> {
    //泛型方法
    public <T> T tell(T t){
        return t;
    }
    public void talk(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        MethodTest<Integer> my=new MethodTest<>();
        //方法签名上无泛型声明的方法，其类型与类定义的一致
        my.talk(12);
        //方法签名上有泛型声明的方法，尽管<>中的参数与类的一致，但是使用时其类型与类无关联
        my.tell("你好");
    }
}
