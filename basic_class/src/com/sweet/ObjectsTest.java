package com.sweet;

import java.util.Objects;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class ObjectsTest {
    static ObjectsTest obj;
    public static void main(String[] args) {
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.toString(obj));

      //要求obj不能为null，如果为null，就会引发异常。
       System.out.println(Objects.requireNonNull(obj,"obj的参数不能是null"));
    }
}
