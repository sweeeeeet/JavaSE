package getClass;

import java.util.Date;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Date date=new Date();
        //1.通过类对象.getClass()
        System.out.println(date.getClass());
        //2.通过类名称.class
        System.out.println(Date.class==date.getClass());
        //3.通过调用Class类提供的静态方法forName(String className)
        System.out.println(Class.forName("java.util.Date"));

    }
}
