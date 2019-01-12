package com.sweet.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author:sweet
 * Created:2019/1/7
 */
public class HashSetTest {
    public static void code1() {
        Set<String> set=new HashSet<>();
        set.add("hello");
        set.add("bit");
        set.add("hello");
        set.add("java");
        System.out.println(set);
    }
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("java");
        set.add("hello");
        set.add("java");
        set.add("best");
        System.out.println(set);
    //判断元素是否存在
        //若是自定义的数据类型,则需要覆写equalS 方法和hashCode方法
        System.out.println( set.contains("ja"));


    }
}
