package com.sweet.filestream;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/5
 */

public class UseFileOutputStream implements AutoCloseable{
public static void code1(){
    File file =new File("D:\\TL-BITE\\Test\\test.txt");
    if(!file.getParentFile().exists()){
        file.getParentFile().mkdirs();
    }
    OutputStream out=null;
    try {
        out=new FileOutputStream(file);
        String msg="我正在学习";
        out.write(msg.getBytes());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }finally {
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

    public static void main(String[] args) {
        File file =new File("D:\\TL-BITE\\Test\\test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
       try(OutputStream out=new FileOutputStream(file)){
            StringBuffer str=new StringBuffer("我已经学习了很久很久了");
            out.write(str.toString().getBytes());
            testClose();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void close() throws Exception {
        System.out.println("已经自动关闭");
    }
    public static void testClose(){

    try(UseFileOutputStream uo=new UseFileOutputStream();){
        System.out.println("我已经学习很久了");
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
