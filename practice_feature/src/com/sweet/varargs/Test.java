package com.sweet.varargs;

/**
 * Author:sweet
 * Created:2018/12/10
 */
public class Test {
    public static void main(String[] args) {
        System.out.println( add(1,2,3));
        System.out.println( add(1, 45, 67, 34, -100));
        tell("小明",66,34.0,88,95.5);
    }
    //使用可变参数就不限定传入参数的个数，但是类型必须对应
    public static double add(int...data){
      double sum=0.0;
        for(double i:data){
            sum+=i;
        }
        return sum;
    }
    //传递多种类型的参数，可变参数要放在参数列表的末尾一个声明
    //一个方法中只能设置一个可变参数
    public static  void tell(String name,double...score){
      int sum=0;
        for(double s:score){
            sum+=s;
        }
        System.out.println(name+"的总成绩为："+sum);
    }
}
