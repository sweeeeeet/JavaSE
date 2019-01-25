package reflectclass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class UseNormalMethod {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class claP=Person.class;
        Class claS=Students.class;
      Method[] method= claP.getMethods();
      for(Method me:method){
          System.out.println(me);
      }

      //1.拿到PersonClass对象
        Class<?> cls=Person.class;

        //2.创建Person实例化对象
Person p= (Person) cls.newInstance();
//3.拿到setName的Method对象
        Method method1=cls.getMethod("setName", String.class);
        //4.通过invoke调用
        method1.invoke(p,"蛋蛋");
        System.out.println(p);
        //拿到name属性的Filed对象
        Field file=cls.getDeclaredField("AGE");
        //设置动态封装
        file.setAccessible(true);

    }
}
