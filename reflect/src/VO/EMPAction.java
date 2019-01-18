package VO;

import java.lang.reflect.InvocationTargetException;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class EMPAction {
    private EMP p=new EMP();
    public void setEMP(String value) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BeanOperation.setBeanValue(p,"emp.name:lihua|emp.job:C");
    }
    public void getEMP() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BeanOperation.setBeanValue(p,"emp.name:lihua|emp.job:C");
    }
}
