package com.practice1130.exceptions;



public class Test2 {
    public static void main(String[] args) {
        Test2 s=new Test2();
        s.test();
    }
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}


