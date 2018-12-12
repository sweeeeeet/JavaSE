package com.sweet.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class AddTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
       //向集合中添加元素
        list.add("1");
        list.add(1,"2");//向当前集合索引为1的位置添加元素
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("List集合:"+list);
        //向集合中的指定位置添加元素
        list.add(0,"0");
        list.add(0,"0");
        System.out.println(list);
        Collection<String> collection=new ArrayList<>();
        collection.add("00");
        collection.add("01");
        collection.add("02");
        //给集合中添加一个集合的所有内容,
        // 若不指定位置,则在当前集合的最后依次添加
        //向当前集合添加的集合,元素类型必须保持一致
        list.addAll(collection);
        System.out.println(list);
        //删除元素
        list.removeAll(collection);//删除当前集合中指定集合的元素
        list.remove(2);//删除索引为2的元素
        list.remove("0");//删除内容为"00"的元素
        System.out.println(list);//-->[0, 2, 3, 4, 5]
    }
}
