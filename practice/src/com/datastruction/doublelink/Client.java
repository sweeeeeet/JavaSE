package com.datastruction.doublelink;

/**
 * Author:sweet
 * Created:2018/11/28
 */
public class Client {
    public static void main(String[] args) {
        Link link= new Link();
        link.add("车头");
        link.add("车厢1");
        link.add("车厢2");
        link.add("车尾");
       link.remove("车头");
        link.remove("车尾");
        link.print();

    }


}
