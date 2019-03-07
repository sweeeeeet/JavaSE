package com.sweet.JVM.singleton;

import java.io.*;

/**
 * Author:sweet
 * Created:2019/1/22
 */
//一个类的实例化对象要能克隆，需实现Cloneable接口
public class Student implements Cloneable,Serializable {
    private String name;
    private Integer age;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student=null;
        student= (Student) super.clone();
        return student;
    }

    public Student cloneStudent(){

        try(
                ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);

                ) {
            //写入
            objectOutputStream.writeObject(this);
            try ( ByteArrayInputStream inputStream=new ByteArrayInputStream(outputStream.toByteArray());
                  ObjectInputStream objectInputStream=new ObjectInputStream(inputStream)){
               //读取
                Student student= (Student) objectInputStream.readObject();
                return student;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
