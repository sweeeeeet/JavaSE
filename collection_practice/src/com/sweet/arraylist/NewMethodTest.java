package com.sweet.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class NewMethodTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>() ;
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.isEmpty());
        System.out.println(list.contains("a"));
//通过调用集合的对象,可以打印出集合元素
        System.out.println(list);
//通过for循环打印集合
       for(int i=0;i<list.size();i++){
           System.out.print(list.get(i));
       }
        System.out.println("----------------------");

       //通过迭代方法打印集合
        Iterator<Integer>  iterator=list.iterator();
       while (iterator.hasNext()){
           System.out.print(iterator.next());
       }
//通过对象数组接收集合元素,foreach打印集合

        //1.使用toArray方法需要强转(Collection接口中的内容),不推荐
      //Integer[]  integers1=(Integer[])list.toArray();//toArray, 返回值是Object[]

        //2.优化toArray方法
       Integer[] integers=new Integer[list.size()];
        list.toArray(integers);
       for(Integer i:integers){
           System.out.println(i);;
       }
    }
}
