package VO;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:sweet
 * Created:2019/1/21
 */
public class TestEMP {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        EMP emp = new EMP();
        String content = "emp.name:lihua|emp.job:C";
        ObjectUtil objectUtil = new ObjectUtil();
        Map<String, Object> map = objectUtil.parseAttributeAndValue(content);
        for(Map.Entry<String,Object>entry:map.entrySet()){
            objectUtil.setObjectValue(emp,entry.getKey(),entry.getValue());
        }
        System.out.println(emp);
    }
}

class ObjectUtil {
    public Map<String, Object> parseAttributeAndValue(String content) {
        Map<String, Object> attributeAndValueMap = new HashMap<>();
        if (content != null || content.length() > 0) {
            String[] pairs = content.split("\\|");
            for (String p : pairs) {
                String[] attributeValue = p.split(":");
                String attributeTemp = attributeValue[0];
                int index = attributeTemp.lastIndexOf(".");
                if (index == -1) {

                } else {
                    String attribute = attributeTemp.substring(index + 1);
                    attribute =
                            attribute.substring(0, 1).toUpperCase() +
                            (attribute.length() == 1 ? "" : attribute.substring(1));
                    String value = attributeValue[1];
                    attributeAndValueMap.put(attribute, value);
                }
            }
        }
        return attributeAndValueMap;
    }

    public void setObjectValue(Object object, String attribute, Object value) throws InvocationTargetException, IllegalAccessException {
        Class cla = object.getClass();
        Method[] methods = cla.getMethods();
        Method method = null;
        for (Method m : methods) {
            if (m.getName().equals("set" + attribute)) {
                method = m;
            }
        }
        //单独处理Integer
        Parameter parameter = method.getParameters()[0];
        if (parameter.getType() == Integer.class) {
            method.invoke(object, Integer.parseInt(String.valueOf(value)));
        } else if (parameter.getType() == Short.class) {
            method.invoke(object, Short.parseShort(String.valueOf(value)));
        } else if (parameter.getType() == Character.class) {
            method.invoke(object, String.valueOf(value).toCharArray()[0]);
        } else if (parameter.getType() == Boolean.class) {
            method.invoke(object, Boolean.parseBoolean(String.valueOf(value)));
        } else if (parameter.getType() == Float.class) {
            method.invoke(object, Float.parseFloat(String.valueOf(value)));
        } else if (parameter.getType() == Long.class) {
            method.invoke(object, Long.parseLong(String.valueOf(value)));
        } else if (parameter.getType() == Double.class) {
            method.invoke(object, Double.parseDouble(String.valueOf(value)));
        } else {
            method.invoke(object, (Object) value);
        }
    }

    public Object getObjectValue(Object object, String attribute) {
        Class cla = object.getClass();
        Method method = null;
        try {
            method = cla.getMethod("get" + attribute);
            return method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
