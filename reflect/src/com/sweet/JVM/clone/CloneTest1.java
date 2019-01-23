package com.sweet.JVM.clone;

/**
 * Author:sweet
 * Created:2019/1/22
 */
public class CloneTest1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher=new Teacher("刘","java");
        Student student=new Student("zhang",12,teacher);
        System.out.println("原Student"+student);
        System.out.println("克隆的student"+student.clone());
        //检验teacher是否拷贝了
        //如果改变teacher信息，student和克隆student中关于teacher的信息都改变了，说明teacher是共享的
        //如果改变teacher信息，student关于teacher的信息都改变了，
        // 克隆student中关于teacher的信息未改变了，明teacher是不共享的

        //最终结果克隆对象也改变了，因此克隆是浅拷贝(仍保留同一个引用对象)
        teacher.setName("Peter");
        System.out.println("改变teacher信息");
        System.out.println("原student"+student);
        System.out.println("克隆student"+student.clone());

        //深拷贝，会同时拷贝一个实例化对象
        //实现深拷贝需用序列化实现（类实现序列化接口）
    }
}
