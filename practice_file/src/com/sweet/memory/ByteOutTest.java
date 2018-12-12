package com.sweet.memory;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class ByteOutTest {
    public static void code1() {
        byte[] b = {'A', 'C', 'F', 'G', 'H'};
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(b, 0, b.length);
        //输出缓冲区的字节数目
        System.out.println("缓冲区的字节数组" + bos.size());
        byte[] bout = bos.toByteArray();
        for (int i = 0; i < bout.length; i++) {
            System.out.println((char) bout[i] + "\t");
        }

    }

    public static void main(String[] args) throws IOException {
        String msg = "hello world";
        InputStream in = new ByteArrayInputStream(msg.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        int temp=0;
        while((temp=in.read())!=-1){
            //将读到的字符转为大写
            out.write(Character.toUpperCase(temp));
        }
        System.out.println(out);
        in.close();
        out.close();
    }
}
