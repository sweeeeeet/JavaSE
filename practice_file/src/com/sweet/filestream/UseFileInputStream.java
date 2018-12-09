package com.sweet.filestream;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/5
 */
public class UseFileInputStream {
    public static void readFilein1(){
        //声明File类
        File file=new File("D:\\TL-BITE\\Test\\test.txt");
        //声明InputStream对象
        InputStream ins=null;
        //声明字节数组，用来存读到的内容
        byte[] b=new byte[512];
        try {
            //使用FileInputStream为InputStream实例化
            ins=new FileInputStream(file);
            try {
                //读取内容并存放到b数组中
                ins.read(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                //不论是否读取成功，最终都关闭流
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(new String(b));

    }
    public static void main(String[] args) {
        //声明File类
        File file=new File("D:\\TL-BITE\\Test\\test.txt");
        InputStream ins=null;
        //根据文件内容的大小,确定数组的长度
        byte[] b=new byte[(int)file.length()];
        int temp=0;
        int len=0;
        try {
            ins=new FileInputStream(file);
            while(((temp=ins.read())!=-1)){
                //按字节读取,将读到的每个字节分别存入数组
                b[len]=(byte)temp;
                len++;
            }
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b));
    }
}
