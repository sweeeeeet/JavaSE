package getClass;

/**
 * Author:sweet
 * Created:2019/1/16
 */
public class FactoryTest {
    public static void main(String[] args) {
        System.out.println(Factory.getInstance("Apple"));
    }
}
interface IFruit{
    void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}
class Factory{
    //构造方法私有化
    private Factory(){}
    //通过Factory的静态方法getInstance获得对象
    public static IFruit getInstance(String className){
        IFruit fruit=null;
        try {
            //通过反射取得类
            Class<?> cls=Class.forName(className);
            //通过反射取得的类获得实例化对象
            fruit= (IFruit) cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}