package com.sweet.JVM.singleton;

/**
 * Author:sweet
 * Created:2019/1/24
 */

 public class Singleton{
    private Singleton() {
    }
    private  volatile static Singleton instance;
    public  static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
