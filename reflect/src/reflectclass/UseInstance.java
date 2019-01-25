package reflectclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class UseInstance {
    public static void main(String[] args) {
        Class<?> cla = Personp.class;


//取得所有权限的构造方法（包含私有构造）
  Constructor<?>[] constructor= cla.getDeclaredConstructors();
//只能取得public权限的构造方法
     Constructor<?>[] constructor1=cla.getConstructors();


        try {
            //取得Pesonp的含有指定类型的构造方法
            cla.getConstructor(String.class,int.class);
            //利用有参构造方法实例化对象
            Personp per= (Personp) constructor[0].newInstance("who",11);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}

class Personp {
    private Personp() {
    }

    protected Personp(String name) {
    }

    private Personp(String naem, int age) {
    }

    @Override
    public String toString() {
        return "Personp{}";
    }
}
