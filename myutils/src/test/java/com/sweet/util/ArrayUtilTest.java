package com.sweet.util;

/**
 * Author:sweet
 * Created:2019/1/17
 */
public class ArrayUtilTest {
    public static void main(String[] args) {
//        int[] num=null;
//        int[] num1=new int[2];
//        System.out.println(ArrayUtil.isEmpty(num));;
//        System.out.println(ArrayUtil.isEmpty(num1));;
        Object[] objects=new Object[2];
        Object[] objects1=null;
        Object object = "String";
        System.out.println(ArrayUtil.isEmpty(objects));;
        System.out.println(ArrayUtil.isEmpty(objects1));;
        System.out.println(ArrayUtil.isEmpty(object));;
        String[] arrarold={"1","g","m","h","t"};
      for(String srt:ArrayUtil.append(arrarold,"w","e","e")){
          System.out.println(srt);
      }


    }
}
