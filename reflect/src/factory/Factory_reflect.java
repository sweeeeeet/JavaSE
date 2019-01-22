package factory;

import java.lang.reflect.Constructor;

/**
 * Author:sweet
 * Created:2019/1/19
 */
//客户端通过直接调用工厂静态方法得到实例化对象
public class Factory_reflect {
    public static void main(String[] args) {

    IFruit_r i=    Factory_r.getIntance(Orange.class.getName());
        i.eat();
    }
}

interface IFruit_r {
    void eat();
}

class Orange implements IFruit_r {

    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

class Strawberry implements IFruit_r {

    @Override
    public void eat() {
        System.out.println("吃草莓");
    }
}

class Factory_r {
    private Factory_r() {
    }

    public static IFruit_r getIntance(String className) {
        try {
            //通过反射获得实例化对象
            IFruit_r iFruit_r = (IFruit_r) Class.forName(className).newInstance();
            return iFruit_r;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
