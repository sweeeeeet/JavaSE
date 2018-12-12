package com.sweet.printstream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Author:sweet
 * Created:2018/12/9
 */
public class ScannerTest {
    public static void code() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年龄");
        //判断下一个输入是否int值
//        if(scanner.hasNextInt()){
        //接收int数据类型
//            System.out.println(scanner.nextInt());
//        }else{
//            System.out.println("输入的不是数字");
//        }
        while (true) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
                break;
            } else {
                System.out.println("输入的不是数字");
                //获取下一行(丢弃不符合要求的数据)
                scanner.next();
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
//代替BufferedReader读取文件(从文件中获取输入)
        try (Scanner scanner = new Scanner(Paths.get("D:","TL-BITE","Test","write.txt"))) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
