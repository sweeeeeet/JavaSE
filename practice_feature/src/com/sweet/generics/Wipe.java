package com.sweet.generics;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class Wipe<T> {
    public static void main(String[] args) {
        Wipe<Integer> integerWipe=new Wipe<>();
        Wipe<String> stringWipe= new Wipe<>();
        System.out.println(integerWipe.getClass().getName());//com.sweet.generics.Wipe
        System.out.println(stringWipe.getClass().getName());//  com.sweet.generics.Wipe
    }
}
