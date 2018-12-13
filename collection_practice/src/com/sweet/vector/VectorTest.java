package com.sweet.vector;

import java.util.*;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class VectorTest {
    public static void main(String[] args) {
        List<String> vector=new Vector<>();
        vector.add("hello");
        vector.add("java");
        vector.add("!!!");
        //已弃用
        Enumeration<String> enumeration=((Vector<String>) vector).elements();
        System.out.println(enumeration);

        //主要使用迭代器遍历输出集合
        Iterator<String> iterator=vector.listIterator();
        while (iterator.hasNext()){
            ((ListIterator<String>) iterator).add("---");

            //修改集合元素不能在迭代之前,会报错
           // ((ListIterator<String>) iterator).set("34");//error

            System.out.println(iterator.next()+",");
            ((ListIterator<String>) iterator).set("***");
            ((ListIterator<String>) iterator).add("+");
        }
while(((ListIterator<String>) iterator).hasPrevious()){
    System.out.println(((ListIterator<String>) iterator).previous());
}
        for(int i=0,len=vector.size();i<len;i++){
            System.out.println(vector.get(i));
            // vector.add("sm");//添加删除操作不能在当前遍历打印下起作用
        }
    }
}
