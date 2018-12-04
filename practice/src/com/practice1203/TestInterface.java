package com.practice1203;

/**
 * Author:sweet
 * Created:2018/12/3
 */
 interface NewInterface {
    void print();
    //新特性中1.可以使用default定义普通方法
    public default void fun(){
        System.out.println("接口中的普通方法");
    }
    //新特性中2.可以使用static定义静态方法方法
    public static NewInterface getNewInterface(){
        return new NewInterfaceImp();
    }
}
class NewInterfaceImp implements NewInterface{

    @Override
    public void print() {
        System.out.println("实现接口的抽象方法");
    }

}
public class TestInterface{
    public static void main(String[] args) {
        NewInterface in=new NewInterfaceImp();
       //普通方法与子类实现的抽象方法都需要对象调用
        in.fun();
        in.print();
        //接口中的静态方法需要接口名调用
        System.out.println(NewInterface.getNewInterface());;
    }
}
