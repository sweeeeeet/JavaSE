package com.sweet.collections;

import java.util.*;

/**
 * Author:sweet
 * Created:2019/1/8
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        for(int i=65;i<=123;i++){
data.add(String.valueOf((char)i));
        }
        System.out.println(data);
        System.out.println("原始数据"+data);
        System.out.println("反转：");
        Collections.reverse(data);
        //二分查找
        //index=-（插入点的下标）-1
       int index= Collections.binarySearch(data, "A");
        System.out.println("查看A下标"+index);
        //乱序
        Collections.shuffle(data);
        //将非同步集合变为同步集合
        //将集合变为不可修改的集合
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("q","退出"));
       map= Collections.unmodifiableMap(map);

       System.out.println(map.put("q","退出"));
        //将集合变为不可修改的集合后再对集合进行修改则会报错
    }
}
