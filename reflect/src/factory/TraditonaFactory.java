package factory;

/**
 * Author:sweet
 * Created:2019/1/19
 *
 * 传统工厂模式增加实现类就需要在工厂类中增加if分支，不符合开闭原则
 */
public class TraditonaFactory {
    public static void main(String[] args) {
        Factory.getInstance("apple").eat();
    }
}
interface Ifruit{

    void eat();
}
class Apple implements Ifruit{

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
class Factory{
    private Factory(){}
    public static Ifruit getInstance(String className){
        if("apple".equals(className)){
            return new Apple();
        }
        return null;
    }
}