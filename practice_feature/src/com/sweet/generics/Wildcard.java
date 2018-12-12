package com.sweet.generics;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class Wildcard {
    public static void main(String[] args) {
        Message<Integer> me=new Message<>();
        me.setMess(23);
        me.getMess();
        Message<?> me2=new Message<>();
       // me2.setMess(23);使用通配符的对象不能调用set方法吧,因为不确定类型
        me2.getMess();//使用通配符的对象可以调用使用范型的属性
        me2.setNaem("啥");//确定类型的属性可以调用set方法.
    }
}
class Message<T>{
    private T mess;
    private String naem;

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public T getMess() {
        return mess;
    }

    public void setMess(T mess) {
        this.mess = mess;
    }
}