package com.sweet.generics;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class WildcardUP {
    public static void main(String[] args) {
        //可以设置Number,及其子类
        PMessage<Number> message = new PMessage<>();
        message.getMes();
        message.setMes(34);
        //PMessage<String> message1=new PMessage<String>();//error,String 不是Number的子类
    Message<? extends Number> message1=new Message<>();
   // message1.setMess(23);//error,设置泛型上限的对象不能调用set方法
    }
}

//泛型的上限在泛型类定义的时候使用
class PMessage<T extends Number> {
    private T mes;

    public T getMes() {
        return mes;
    }

    public void setMes(T mes) {
        this.mes = mes;
    }
}