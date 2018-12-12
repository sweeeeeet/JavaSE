package com.sweet.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Author:sweet
 * Created:2018/12/12
 */
public class SaveObject {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("jack", 12));
        people.add(new Person("jay", 23));
        people.add(new Person("Alice", 33));
        System.out.println(people);

        //使用覆写的equals方法,返回值就为true
        //equals方法与hashCode方法要一起覆写
        //若不同时覆写,其hashCode的值依然不同,
        // 在Map中,KEY的值由hashCode决定,因此会造成有相同的元素出现.
        System.out.println(people.contains(new Person("jack", 12)));
        people.remove(2);
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //手工完成
//@Override
//    public boolean equals(Object obj){
//        if(obj==null){
//            return  false   ;
//        }
//        if(this==obj){
//            return true;
//        }
//        if(obj instanceof Person){
//            Person that=(Person)obj;
//             return this.getName().equals(that.getName()) &&
//                    this.getAge().equals(that.getAge());
//        }
//        return false;
//}


    //工具生成
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        return age.equals(person.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }
}
