package com.sweet.JVM.singleton;

/**
 * Author:sweet
 * Created:2019/1/22
 */
public class CloneTest2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //深拷贝，会同时拷贝一个实例化对象
        //实现深拷贝需用序列化实现（类实现序列化接口）
        Teacher teacher=new Teacher("刘","java");
        Student student=new Student("zhang",12,teacher);
        System.out.println("原student"+student);
        Student cloneStudent=student.cloneStudent();
        System.out.println("克隆student"+cloneStudent);

        teacher.setName("Peter");
        System.out.println("改变teacher信息");
        System.out.println("原student"+student);
        System.out.println("克隆student"+cloneStudent);

    }
}
