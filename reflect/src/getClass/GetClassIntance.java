package getClass;

import java.util.Date;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class GetClassIntance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.取得类的Class对象
        Class<Date> cls= (Class<Date>) Class.forName("java.util.Date");
        //通过反射取得Date类实例化对象
        Date date=cls.newInstance();
        System.out.println(date);
    }
}
