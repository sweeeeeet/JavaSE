package com.github.sweeeeeet;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            String b = in.nextLine();

            System.out.println(delete(a, b));
        }
    }

    public static String delete(String a, String b) {
StringBuffer sb=new StringBuffer();
        char[] ch = a.toCharArray();
        for (int i = 0; i < b.length(); i++) {
            char bb = b.charAt(i);
            for (int j = 0; j < a.length(); j++) {
                char aa = a.charAt(j);
                //保证b是不重复的字符串
                if (aa == bb) {
                    ch[j] = ' ';
                }
            }
        }

        for(char c:ch){
            if((c>='a'&&c<='z')||c==' '){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}