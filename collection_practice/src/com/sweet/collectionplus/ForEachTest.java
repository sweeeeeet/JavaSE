package com.sweet.collectionplus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Author:sweet
 * Created:2019/1/15
 */
public class ForEachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"java","c++","python","javaScript");
        list.forEach(System.out::println);
        Stream<String> stream=list.stream();
        System.out.println(stream.count());
    }
}
