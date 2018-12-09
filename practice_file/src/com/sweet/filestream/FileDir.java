package com.sweet.filestream;

import java.io.File;
import java.util.Date;

/**
 * Author:sweet
 * Created:2018/12/5
 */

public class FileDir {
    public static void code1(){
        File file=new File("D:\\TL-BITE\\Test\\mkdir");
        //D:\TL-BITE\Test存在,只用创建当前一层目录mkdir
        if(file.mkdir()){
            System.out.println("D:\\TL-BITE\\Test\\mkdir创建成功");//ok
        }else{
            System.out.println("创建失败");
        }
        File file1=new File("D:\\TL-BITE\\Test\\test1\\mkiirs");
        //D:\TL-BITE\Test存在,需创建多层目录
        if(file1.mkdirs()){
            System.out.println("D:\\TL-BITE\\Test\\test1\\mkiirs创建成功");//ok
        }else{
            System.out.println("D:\\TL-BITE\\Test\\test1\\mkiirs创建失败");
        }

    }
    public static void main(String[] args) {
        File file =new File("D:\\TL-BITE\\Test");
        if(file.exists()){
            System.out.println(file.getName());//获取文件名
            System.out.println(file.getPath());//获取文件路径
            System.out.println(file.length());//获取文件大小
            System.out.println(file.lastModified());//获取文件上一次修改时间

            //利用文件上一次修改时间作为Date类对象,输出年月日格式时间
            System.out.println(new Date(file.lastModified()));
        }
           }
}
