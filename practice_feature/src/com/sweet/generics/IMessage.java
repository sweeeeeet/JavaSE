package com.sweet.generics;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public interface IMessage <T>{
   void print(T x);
    //1.匿名内部类实现接口的泛型方法
  IMessage<String> imessage=new IMessage<String>() {
        @Override
        public  void print(String str) {
            System.out.println(str);
        }
    };
}
//2.子类实现接口时继续使用泛型
class Imple<T> implements IMessage<T>{

    @Override
    public void print(T x) {

    }
}
//3.子类实现接口给出具体类型
class Imple2<String> implements IMessage{
    @Override
    public void print(Object x) {

    }
}