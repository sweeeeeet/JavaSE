import javax.sound.midi.Soundbank;

/**
 * Author:sweet
 * Created:2018/11/26
 */
class Test{
public static void code(){
//private static final Singleton singleton=new Singleton();
//
//public  static Singleton getInstance(){
//
//        return singleton;
//        }
//
//private Singleton() {
//
//        }
        }
public static void code2(){
//    private static final Singleton singleton;
//
//    static {
//        singleton=new Singleton();
//    }
//
//    private Singleton() {
//
//    }
//    public static Singleton getIntance(){
//
//        return singleton;
//    }

}
public void code3(){
//    private Singleton singleton;
//
//
//    private Singleton() {
//
//    }
//    public  Singleton getSingleton(){
//        if(singleton==null){
//            synchronized (Singleton.class){
//                if(singleton==null){
//                    singleton=new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//

}
        }
//public class Singleton {
//
//private  Singleton(){}
//
//private static class InnerSinleton{
//    private static final  Singleton SINGLETON=new Singleton();
//    }
//
//    public static Singleton getSingleton(){
//
//    return InnerSinleton.SINGLETON;
//    }
//
//}
public enum Singleton{
    SINGLETON1(12),SINGLETON,SINGLETON2;
    private int age;

    Singleton() {

    }

    Singleton(int age) {
        this.age = age;
    }
public void print(){
    System.out.println("枚举类中的普通方法");
}
    public static void getname() {
        Singleton[] name = Singleton.values();
        Singleton name1 = Singleton.valueOf("SINGLETON");
        System.out.println(name1);
        System.out.println(name[2]);
    }

    public static void main(String[] args) {
        Singleton.getname();
        SINGLETON.print();
        Singleton.SINGLETON.print();
    }
}

enum Singleton1{
    SINGLETON_1;
    public void method(){

    }
}

