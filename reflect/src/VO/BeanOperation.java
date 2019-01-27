package VO;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class BeanOperation {
    public static void setBeanValue(Object o,String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
      //  "emp.name:lihua|emp.job:C"
        //第一次拆分
        String[] first=value.split("\\|");
        for(int i=0,len=first.length;i<len;i++){
            //第二次拆分
           String[] seconed= first[i].split(":");
           String setValue=seconed[1];
           String attribute=seconed[0].split("\\.")[1];
           String setName="set"+BeanOperation.toUpper(attribute);
           //利用反射调用方法并set值
            Field field=o.getClass().getField(setValue);
            if (field == null) {
                // 第二次尝试从父类中取得该属性            
                field = o.getClass().getField(attribute) ;
            }if (field == null) {
                // 两次都未取得指定属性的对象，表示该对象一定不存在            
                return  ;
            }
          Method method=  o.getClass().getMethod(setName,field.getType());
          method.invoke(o,setValue);
            getBeanObject(o, attribute);
        }
    }

    public static Object getBeanObject(Object o, String attribute) {
        String getName="get"+BeanOperation.toUpper(attribute);
        Object obj=null;
        try {
            Method method=o.getClass().getMethod(getName);
         obj=method.invoke(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static String toUpper(String value){
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }


}
