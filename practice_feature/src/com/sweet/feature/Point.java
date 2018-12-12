package com.sweet.feature;

/**
 * Author:sweet
 * Created:2018/12/10
 */

public class Point<T, R> {
    private T x;
    private R y;

    public Point(T x) {
        this.x = x;
    }

    public Point(T x, R y) {
        this.x = x;
        this.y = y;
    }

    public void getInfo() {
        System.out.println(x);

    }

    public static void main(String[] args) {
        //创建泛型类的对象时（使用泛型）必须声明指定的类型
        Point<String,Integer> p = new Point<>("张三");
        //定义类时声明的T,R可以代表任意类型
        Point<String,Double> p1 = new Point<String, Double>("张三",24.5);
        p.getInfo();
        p1.getInfo();

    }

}
