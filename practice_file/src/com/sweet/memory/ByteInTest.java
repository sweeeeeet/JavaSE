package com.sweet.memory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class ByteInTest {
    public static void main(String[] args) {
        byte[] b=new byte[]{'a','c','b','g'};
        ByteArrayInputStream bis = new ByteArrayInputStream(b, 0, b.length);
        int temp=bis.read();
        while (temp!=-1){
            System.out.println((char)temp+"\t");
            temp=bis.read();
        }
        try{
            bis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println();
    }
}
