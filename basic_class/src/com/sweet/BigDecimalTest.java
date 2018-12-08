package com.sweet;

import java.math.BigDecimal;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal f1=new BigDecimal("0.05");
        BigDecimal f2=new BigDecimal("0.01");
        BigDecimal f3=new BigDecimal("99.793");
        System.out.println("0.05+0.01="+f1.add(f2));
       // System.out.println("0.05+0.01="+(0.05+0.01));//0.05+0.01=0.060000000000000005
        System.out.println("0.05-0.01="+f1.subtract(f2));
        System.out.println("0.05*0.01="+f1.multiply(f2));
        System.out.println("0.05/0.01="+f1.divide(f2));
    }
}
