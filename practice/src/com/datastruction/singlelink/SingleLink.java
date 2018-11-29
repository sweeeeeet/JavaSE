package com.datastruction.singlelink;

/**
 * Author:sweet
 * Created:2018/11/28
 */
public class SingleLink {
    public static void main(String[] args) {
        Node head=new Node("车头",null);
        Node one=new Node("车箱1",null);
        Node two=new Node("车箱2",null);
        Node tail=new Node("车头尾",null);
        head.setNext(one);
        one.setNext(two);
        two.setNext(tail);
    }
}
