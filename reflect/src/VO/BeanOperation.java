package VO;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class BeanOperation {
    public static void setBeanValue(Object o, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1.字符串拆分"emp.name:lihua|emp.job:C"
        String[] temp = value.split("\\|");
        //emp.name:lihua|emp.job:C
        for (int i = 0; i < temp.length; i++) {
            String[] res = temp[i].split(":");
            //emp.name:lihua
            //取得真实值
            String realvalue = res[1];
            //取得真实类
            String realClassName = res[0].split("\\.")[0];
            //取得属性
            String attrName = res[0].split("\\.")[1];

            //通过反射取得xxAction中的真实对象
            Object realObj = getBeanObject(o, realClassName);
            Class<?> cla=o.getClass();
            String setName = "set" + toUpper(realClassName);
            Method method = cla.getMethod(setName);
            method.invoke(o,realvalue);
        }
    }

    public static Object getBeanObject(Object o, String realClassName) {
//取得Action对象的class对象
        Class<?>cla=o.getClass();
        // 取对象
        Object realObj=null;
        try {
            //拼接get方法名
        String method="get"+toUpper(realClassName);
        //获取方法对象
            Method method1 = cla.getMethod(method);
            //调用方法
           realObj= method1.invoke(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return realObj;
    }
    public static String toUpper(String value){
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
