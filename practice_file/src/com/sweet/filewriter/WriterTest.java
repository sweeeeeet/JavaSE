package com.sweet.filewriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class WriterTest {
    public static void code1() {
        File file = new File("D:\\TL-BITE\\Test\\writeit.txt");
        Writer out = null;
        String str = "飞雪连天射白鹿\t";
        //write方法支持字符数组写入
        char[] c = str.toCharArray();
        try {
            out = new FileWriter(file);
            out.write(c);
            out.append("神书仙侠倚奇缘");
            //写入操作完成需关闭流
           // out.flush();
            out.close();
            System.out.println("写入成功");
        } catch (IOException e) {
            System.out.println("写入失败");
            e.printStackTrace();
        }

    }

    public static void code2() {
        File file = new File("D:\\TL-BITE\\Test\\write.txt");
        //利用try-with-resources实现自动关闭流
        try (Writer out = new FileWriter(file)) {
            String msg = "神书仙侠倚奇缘";
            //write方法中写入支持字符串\数组\整数
            out.write(msg,2,4);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\TL-BITE\\Test\\write\\write1.txt");
        //若当前文件不存在,new File可自动创建文件,
        // 若上层目录都不存在,则创建失败,需创建目录
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        String msg = "我正在学习字符流";
        try (Writer out = new FileWriter(file);) {
            out.write(msg.toCharArray(), 0, 3);
            System.out.println("写入成功");
        } catch (IOException e) {
            System.out.println("写入失败");
            e.printStackTrace();
        }

    }
}
