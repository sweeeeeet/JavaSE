package com.practice1201;

/**
 * Author:sweet
 * Created:2018/12/1
 */
public class StaticInnerTest {
    private int num;
    private static int age;
    static class Inner{
        public void print(){
            System.out.println("静态内部类中的非静态方法");
        }
    }

    public static void main(String[] args) {
        Inner inner=new Inner();
        inner.print();
    }
}
class Test{
    public static void main(String[] args) {
        StaticInnerTest.Inner in=new StaticInnerTest.Inner();
    }
}