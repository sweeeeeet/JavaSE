package com.practice1128;

/**
 * Author:sweet
 * Created:2018/11/28
 */
public class ExceptionTest2 {
    public static void main(String[] args) {
        try {
            Execeptions.calcu(2, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Execeptions {

    public static int calcu(int x, int y) {
        System.out.println("1.开始计算");
        int res = 0;
        try {
            res = x / y;
        }
        //可加可不加,throw与throws不一定非需要同时出现
        catch (Exception e) {
           throw e;
        }
        finally {
            System.out.println("计算结束");
        }
        return res;
    }
}

