package com.sweet.object;

/**
 * Author:sweet
 * Created:2018/11/26
 */
public class CasingTest {
    public void code1() {
        //利用构造方法装箱
        Integer num = new Integer(12);
        //直接装箱
        Integer num2 = 12;
        //利用方法拆箱
        Boolean bool = new Boolean(true);
        boolean bool2 = bool.booleanValue();
        int num3 = num.intValue();
        System.out.println(num);//12
        System.out.println(num2);//12
        System.out.println(num3);//12
        System.out.println(++num);//13
        System.out.println(bool2);//13


    }

    public void code2() {
        Integer num1 = 12;
        Integer num2 = 12;
        Integer num3 = 153;
        Integer num4 = 153;
        Integer num5 = new Integer(100);
        Integer num6 = new Integer(100);
        System.out.println(num1 == (num2));//true
        System.out.println(num4 == (num3));//false
        System.out.println(num5 == (num6));//false
    }

    public void code3() {
        String string = "123.123";
        String string1 = "123";
        String string2 = "true";
        String string3 = "false";
        System.out.println(Integer.parseInt(string1));
        System.out.println(Double.parseDouble(string));
        System.out.println(Boolean.parseBoolean(string2));//true
        System.out.println(Boolean.parseBoolean("trues"));//false
        System.out.println(12 + "");
        System.out.println(String.valueOf(12));
        System.out.println(1000_000_00);//100000000
        int a = 0b10010;
        System.out.println(a);//18

    }

    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        int c = a + b;

    }

}
