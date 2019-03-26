package VO;

import java.lang.reflect.InvocationTargetException;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class EMPAction {
    private EMP p=new EMP();
    public void setEMP(String value) {
        try {
            BeanOperation.setBeanValue(this,value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public EMP getEMP(){
        return p;
    }
}
