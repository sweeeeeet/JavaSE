package com.sweet.map;

import java.util.*;

/**
 * Author:sweet
 * Created:2019/1/9
 */
public class HashMapTest {
    public static void main(String[] args) {
            Map<Integer, String> map = new HashMap<>();
            //key值可重复
            map.put(1, "一班");
            map.put(1, "一班优");
            map.put(1, "一班差");
            map.put(2, "二班");
            map.put(3, "三班");
            map.put(4, "四班");
            //根据key取得value
            System.out.println(map.get(1));
        //取得Map中所有Key的信息
        Set<Integer> set=map.keySet();
        System.out.println(set);
        //取得Map中所有value信息
        Collection collection=map.values();
        System.out.println(collection);


        //通过Set集合中的 iterator方法输出Map

        //1.将Map集合变为Set集合
        Set<Map.Entry<Integer,String>> setMap=map.entrySet();
       //获得Iterator对象
        Iterator<Map.Entry<Integer,String>> iterator=setMap.iterator();
        while(iterator.hasNext()){
            //取出每一个Map.Entry对象
            Map.Entry<Integer,String> entry=iterator.next();
            //取得key value
            System.out.println(entry.getKey()+"="+entry.getValue());

        }
    }
}
