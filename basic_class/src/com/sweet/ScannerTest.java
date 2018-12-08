package com.sweet;

import java.util.Scanner;

/**
 * Author:sweet
 * Created:2018/12/7
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //只把回车作为分割符
        scan.useDelimiter("\n");
        //Scanner 提供两个方法扫描输入:
        // 1.hasNext基本数据类型();
        //若只是判断是否还有下个输入项，则直接使用hasNext()
        //2.nextXxx
        while(scan.hasNext()){
            System.out.println("键盘输入的内容是:"+ scan.next());
        }
    }
}
