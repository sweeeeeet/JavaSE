package com.sweet.staticinner;

/**
 * Author:sweet
 * Created:2018/12/7
 */
interface Test{
    //接口中默认内部类是静态的
    class InnerTest{
        private static int num;
        private  int num2;
        public void info(){
            System.out.println(new InnerTest().num2);
            System.out.println(num2);
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Test.InnerTest t=new InnerTest();
    }
        }
public class AccessInner {
    static class InnerStatic{
        private   static int propl=5;
        private  int Propl2=9;
        public void accessInner(){
            //访问静态内部类的静态成员可以直接访问或通过内部类的类名访问
            System.out.println(propl);
            //访问静态内部类的非静态成员需通过对象访问，与普通类一样
            System.out.println(new InnerStatic().Propl2);
        }
        public static void get(){
            InnerStatic in=new InnerStatic();
            System.out.println(propl);
            //静态方法中访问非静态成员只能通过实例对象访问
            System.out.println(in.Propl2);
        }
    }
}
