/**
 * Author:sweet
 * Created:2018/11/26
 */

public class Singleton{
private static final Singleton singleton=new Singleton();

public  static Singleton getInstance(){

        return singleton;
        }

Singleton() {

        }
        }
class Singleton1{
    private static final Singleton1 singleton1;

    static {
        singleton1=new Singleton1();
    }

    private Singleton1() {

    }
    public static Singleton1 getIntance(){

        return singleton1;
    }

}
class Singleton2{
    private Singleton2 singleton2;


    private Singleton2() {

    }
    public  Singleton2 getSingleton(){
        if(singleton2==null){
            synchronized (Singleton2.class){
                if(singleton2==null){
                    singleton2=new Singleton2();
                }
            }
        }
        return singleton2;
    }


}

 class Singleton3 {

private  Singleton3(){}

private static class InnerSinleton{
    private static final  Singleton SINGLETON=new Singleton();
    }

    public static Singleton getSingleton(){

    return InnerSinleton.SINGLETON;
    }

}



