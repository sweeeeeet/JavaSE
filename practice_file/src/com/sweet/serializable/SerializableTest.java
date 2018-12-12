package com.sweet.serializable;

import java.io.*;

/**
 * Author:sweet
 * Created:2018/12/10
 */
class Person implements Serializable {
    private String name;
    private int age;
    private String school;


    public Person(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public  void  tell() {
        System.out.println("名字" + name + "年龄" + age + "学校" + school);
    }
}

public class SerializableTest{
    public static File file = new File("D:\\TL-BITE\\Test\\print.txt");

    public static void serOutTest(Object obj) {
//将序列化对象写入文件
        try (ObjectOutputStream obo = new ObjectOutputStream(new FileOutputStream(file))) {
            obo.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void serInTest() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Person p1=(Person)ois.readObject();
            p1.tell();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        serOutTest(new Person("张三", 23, "清华大学"));
        serInTest();

    }
}

