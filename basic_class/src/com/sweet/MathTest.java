package com.sweet;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class MathTest {
    public static void main(String[] args) {
//        System.out.println("将弧度转化为角度：Math.toDegrees(1.57)\t"+Math.toDegrees(1.57));
//        System.out.println("将角度转化为弧度：Math.toRadians(90)\t" + Math.toRadians(90));
//        System.out.println("计算反余弦:Math.acos(1.2)\t"+Math.acos(1.2));
//        System.out.println("计算反正弦:Math.asin(0.8)\t"+Math.asin(0.8));
//        System.out.println("计算计算双曲正弦:Math.cosh(1.2)\t"+Math.cosh(1.2));
//        System.out.println("计算计算双曲正切:Math.cosh(1.2)\t"+Math.tanh(2.1));
//        //向下取整
//        System.out.println("Math.floor(-1.2)\t"+Math.floor(-1.2));
//
//       //向上取整
//        System.out.println("Math.ceil(-1.2)\t"+Math.ceil(-1.2));
//
//       //四舍五入取整
//        System.out.println(Math.round(2.5));
//        //计算平方根
//        System.out.println("Math.sqrt(1.2)"+Math.sqrt(1.2));
//        //计算立方根
//        System.out.println("Math.cbrt(3)"+Math.cbrt(3));
//        //返回（x1+x2）的平方根
//        System.out.println("Math.hypot(2,3)"+Math.hypot(2,3));
//        //计算底数为10的自然对数
//        System.out.println("Math.log10(100)"+Math.log10(100));
//        //计算绝对值
//        System.out.println("Math.abs(-4.5)"+Math.abs(-4.5));
//        //符号赋值，返回第二个带有浮点符号的第一个浮点参数
//        System.out.println("Math.copySign(1.2,-1.0)"+Math.copySign(1.2,-1.0));
//        //符号函数
//        System.out.println("Math.signum(120)"+Math.signum(120));
        //找出最大值
        System.out.println(Math.max(1.2,3.4));
        //计算最小值
        System.out.println(Math.min(1.2,1.3));
        //返回第一个参数和第二个参数之间与第一个参数相邻的浮点数
        System.out.println(Math.nextAfter(1.2,3));
        //返回比浮点数略大的浮点数
        System.out.println(Math.nextUp(12.2));
        //返回一个伪随机数，该值大于等于0.0且小于1.0
        System.out.println(Math.random());
    }

}
