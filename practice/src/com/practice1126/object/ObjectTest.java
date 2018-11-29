/**
 * Author:sweet
 * Created:2018/11/26
 */
public class ObjectTest {
//public static void  main(String[] args){
//    Person person=new Person(18,"tina");
//    Person person1=new Person(18,"tina");
//    Person person2=person;
//    Person person3=new Person(16,"nihd");
//    System.out.println(person.equals(person1));
//    System.out.println(person.equals(person2));
//    System.out.println(person.equals(person3));
//}

    public static void main(String[] args) {
//        Object向上转型，接受int[]数组
        Object array1=new int[]{1,2,3,4};
//      需使用数组时需向下转型
        int[] array=(int[])array1;
        for (int temp:array){
            System.out.println(temp);
        }
    }

//Object类接收对象（引用数据类型）
    public static void fun(Object object){
    System.out.println(object.toString());
    }

}
class Person {
    private String name;
    private int age;


    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return  false;
        }
        Person person=(Person) obj;
        return this.name.equals(person.name) && this.age==person.age;
    }
}
class Student{
    private String   name;
    private  int age;
public Student(int age,String name){
    this.age=age;
    this.name=name;
}
    @Override
    //覆写Object类中的toString方法
    public  String toString(){
        return "姓名" + this.name + "年龄" + age;
    }
}

