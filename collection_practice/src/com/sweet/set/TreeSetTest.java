package com.sweet.set;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author:sweet
 * Created:2019/1/7
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //可以通过给TreeSet对象传入一个Comparable对象参数,或是继承Comparable接口
        // 覆写其compareTo方法,自定义排序

        //1.传入接口,利用匿名内部类或是lambda表达式实现Comparable接口
        Set<String> set= new TreeSet<>(
                //lambda表达式
               // (o1, o2) -> o1.compareTo(o2)*-1

                //匿名内部类
        new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }

        );
        set.add("java");
        set.add("c++");
        set.add("python");
        set.add("php");
        set.add("java");
        Iterator<String> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //用TreeSet排序自定义数据类型Person
        //可通过在Person类中实现排序接口,覆写排序方法来定义比较策略
        Set<Person> people = new TreeSet<>();
        //通过泛型指定要比较的数据类型(此数据类型中含有比较方法)
        people.add(new Person(12,"ming"));
        people.add(new Person(13,"fang"));
        for(Person p: people){
            System.out.println(p);
        }

       //若想该表比较策略,可通过给TreeSet对象传入Comparator接口的方法改变
        //这样改变的方法灵活,不需要去数据类型的内部改变compareTo方法
        Set<Person> people1=new TreeSet<>(
                new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return (o1.getName()).compareTo(o2.getName());
                    }
                }
        );
        Set<Student> students=new TreeSet<>(
                (o1, o2) -> o1.getAge()-o2.getAge()
        );
        students.add(new Student(12, "liu"));
        students.add(new Student(13, "wang"));
        students.add(new Student(24, "wang"));
        students.add(new Student(14, "li"));
        System.out.println(students);
    }

}
class Student{
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
//自定义数据类型通过继承接口实现排序
class Person implements Comparable<Person>{
private int age;
private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.getAge();//覆写compareTo方法定义比较策略
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
