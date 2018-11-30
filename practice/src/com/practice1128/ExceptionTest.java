package com.practice1128;

/**
 * Author:sweet
 * Created:2018/11/28
 */
public class ExceptionTest {
    //    public static void main(String[] args) {
//        int i[]={1,2,3};
//        try{
//            System.out.println("i[0]"+i[0]);
//            System.out.println("i[3]"+i[3]);
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("异常!"+e);
//            //e.printStackTrace();
//        }
//        System.out.println("i[1]"+i[1]);
//    }

//
//    public static void main(String[] args) {
//        System.out.println("1.计算开始前");
//        try {
//            System.out.println("2.计算开始" + 2 / 0);
//        } catch (Exception e) {
//            e.getMessage();
//        } finally {
//            System.out.println("不管是否出现异常都会打印");
//        }
//        {
//            System.out.println("3.计算结束");
//        }
//    }
    public static int calcu(int x, int y) throws Exception {
        return x / y;
    }

//    public static void main(String[] args) {
//        try {
//            ExceptionTest.calcu(2, 0);
//        } catch (Exception e) {
//            System.out.println("有异常");
//        }
//        System.out.println("计算完成");
//    }
//}

    //使用throw抛异常
    public static void arrException() {
        throw new NullPointerException("自行抛出异常");
    }

    public static void main(String[] args) {
        try {
            arrException();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

