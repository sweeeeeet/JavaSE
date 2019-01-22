package reflectclass;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class GetPackage {
    public static void main(String[] args) {
        //通过反射取得类
        Class<?> cls=String.class;
        //通过反射取得类所在的包名
        System.out.println(cls.getPackage().getName());
        //取得父类信息
        Class<?> cls1=Students.class;
        System.out.println(cls1.getSuperclass().getName());
        //取得父类接口信息
        Class<?>[] classes=cls.getInterfaces();
        for(Class cla:classes){
            System.out.println(cla.getName());
        }
    }
}

class Person{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
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

    private void test(){}
    protected  void fun(){}
    public void haha(){}
}
interface INews{}
interface Imessage{}
class Students extends Person implements INews,Imessage{
    private void test1(){}
    protected  void fun1(){}
    public void haha1(){}
}