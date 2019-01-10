package com.sweet.collectionplus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author:sweet
 * Created:2019/1/8
 */
public class CollectionStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //1.forEach 来自于Iterable

        Collections.addAll(list,"php", "java", "go");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //lambda表达式
        list.forEach(s -> {
            System.out.println(s);
        });
       //2.Stream来自于Collection
        System.out.println(list.stream().count());
        //若包含Java则遍历打印
        list.stream()
                .filter(s->s.contains("java"))
                .map(s->s.toUpperCase())//将list元素转为大写
                .forEach(System.out::println);
        //普通写法,将集合中的元素转为大写放入另一个集合
        List<String> newList=new ArrayList<>();
        for(String item:list){
            if (item.contains("java")){
                newList.add(item.toUpperCase());
            }
        }
        System.out.println(newList);
        //利用stream写法
        List<String> newList1=list.stream()
                .filter(s->s.contains("java"))//断言函数，进行数据过滤
                .map(s->s.toUpperCase())
                .collect(Collectors.toList());//Collectors.toList()收集器作用
        System.out.println(newList1);
        //将Integer转为String
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(11);
        list1.add(111);
        List<String> list2=list1
                .stream()
                .map(s->String.valueOf(s))
                .collect(Collectors.toList());

        //符合条件的个数统计
        long count=list.stream().filter(s -> s.contains("java")).count();
        System.out.println(count);
        System.out.println("---------------------");

        //skip与limit方法实现分页
       list.stream()
               .skip(1)//跳过1个
               .limit(2)//取2个
               .forEach(System.out::println);

        System.out.println("----------------------");
       list.stream()
               .skip(0)
               .limit(1)
               .forEach(System.out::println);

    }

}
