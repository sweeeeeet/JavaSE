package com.sweet.printstream;

import java.io.*;
import java.nio.file.Paths;

/**
 * Author:sweet
 * Created:2018/12/8
 */
public class PrintTest {
    private OutputStream outputStream;

    public PrintTest(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void print(String string) {
        try {
            outputStream.write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String string) {
        try {
            outputStream.write(string.getBytes());
            outputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(int in) {
        println(String.valueOf(in));
    }

    public void println(double d) {
        println(String.valueOf(d));
    }

    public static void main(String[] args) {
        //传入参数为控制台，意味着将打印输出写入控制台
        //    PrintTest pt=new PrintTest(System.out);
        try (FileOutputStream fos = new FileOutputStream("D:\\TL-BITE\\Test\\print.txt");
        ) {
            //参数为文件，意味着将打印输出流写入文件
            PrintTest pt = new PrintTest(fos);
            pt.println("你好");
            pt.println(12);
            pt.println(12.45);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void code() {
        String name = "张三";
        int age = 25;
        double salary = 1234.000;

        try {
            FileOutputStream fos = new FileOutputStream("D:\\TL-BITE\\Test\\write.txt");
            PrintStream ps = new PrintStream(fos);
            ps.println(12);
            ps.print(false);
            ps.print("nihao");
            ps.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
