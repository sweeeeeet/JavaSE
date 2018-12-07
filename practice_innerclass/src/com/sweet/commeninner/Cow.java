package com.sweet.commeninner;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class Cow {
    public double weight;

    public Cow() {
    }

    public Cow(double weight) {
        this.weight = weight;
    }

    private class CowLeg {
        private double length;
        private String colour;

        public CowLeg() {
        }

        public CowLeg(double length, String colour) {
            this.length = length;
            this.colour = colour;
        }
        public  void info(){
            System.out.println("当前牛腿的颜色是"+colour+
                    ",高："+length);
            //直接访问外部类的成员属性
            System.out.println("奶牛重："+weight);
        }
    }
    public void test(){
        //在外部类的普通方法中要想访问内部类成员，需要开辟内部类的对象实例
        CowLeg c1=new CowLeg(1.2,"黑白相间");
        c1.info();
    }

    public static void main(String[] args) {
        Cow cw=new Cow(542.7);
        cw.test();
    }
}
