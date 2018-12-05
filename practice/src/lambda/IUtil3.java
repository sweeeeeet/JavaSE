package lambda;

/**
 * Author:sweet
 * Created:2018/12/3
 */
@FunctionalInterface
public interface IUtil3 {
//    String  print(String s,int i,int j);
//
//    public static void main(String[] args) {
//        IUtil3 iUtil3=(a,b,c)->a.substring(b,c);
//        IUtil3 iUtil4=String::substring;
//        System.out.println( iUtil4.print("hello world",2,4));;
//
//    }

    //抽象方法入参为Person类，返回类型为String
    String getInfo(Person person);

    public static void main(String[] args) {
       //引用Person的普通方法getPersonInfo
        IUtil3 iUtil33=Person::getPersonInfo;
        System.out.println(iUtil33.getInfo(new Person(23,"nancy")));;
    }
}
class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public String getPersonInfo(){
        return "姓名"+this.name+"年龄"+this.age;
    }
}
