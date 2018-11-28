package designpattern;

/**
 * Author:sweet
 * Created:2018/11/27
 */
//1.饿汉式单例
class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {

    }

    public void print() {
        System.out.println("hello");
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
//饿汉式2 (静态块)
class Singleton2{
    private static Singleton2 singleton2;
    private Singleton2(){}
    static {
        singleton2=new Singleton2();
    }
    public static Singleton2 getSingleton2(){
        return  singleton2;
    }
}
//懒汉式,会有线程不安全的风险,双重检查:
class Singleton3{
    private static Singleton3 singleton3;
    private  Singleton3(){}
    public Singleton3 getSingleton3(){
        if(singleton3==null){
            synchronized (Singleton.class){
                if(singleton3==null){
                return new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
//4.懒汉式,静态内部类
class Singleton4{
    private Singleton4() {
    }
    private static class Inner{
    private static Singleton4 singleton4=new Singleton4();
    }
    public static Singleton4  getSingleton4(){
        return Inner.singleton4;
    }

}
//5.通过枚举类方法
enum Singleton5{
    SINGLETON_INSTANCE;
}
public class SingletoTest {
    public static void main(String[] args) {
        Singleton4 singleton4;
      singleton4=Singleton4.getSingleton4();

    }


}
