package com.sweet.properties;

import java.io.*;
import java.util.Properties;

/**
 * Author:sweet
 * Created:2019/1/8
 */
public class PropertiesTest {
    public static void main(String[] args) {
        //因为Properties继承了Hashtable,因此可以用get put方法
        //*.properties  ->属性文件
        //Properties    ->属性类
        //读取文件：load ->Properties InputStream
        //写入文件：store ->Properties OutputStream
        Properties properties=new Properties();

        //读取属性
        try {
            //1.通过文件流读取属性
            properties.load(new FileInputStream("D:\\TL-BITE\\JAVA\\java_examples\\collection_practice\\src\\com\\sweet\\properties\\hello.properties"));
           //
            InputStream inputStream= PropertiesTest.class.getClassLoader()
                    .getResourceAsStream("com/sweet/properties/hello.properties");//文件名须包含包名
            properties.load(inputStream);
            System.out.println(properties.get("c++"));
            System.out.println("java");
            //当某个属性可能没有时，利用getProperty方法，为属性（key）赋值
            System.out.println(properties.getProperty("php","nice"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.put("go", "better");
        properties.setProperty("python", "hard");

        //将写的key存入
        try {
            properties.store(new FileOutputStream("D:\\TL-BITE\\JAVA\\java_examples\\collection_practice\\src\\com\\sweet\\properties\\hello-1.properties"),"写入");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
