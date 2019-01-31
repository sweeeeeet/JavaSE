package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:sweet
 * Created:2019/1/23
 */
public class AnnotationFruit {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        IFruit fruit=Factory.getInstance();
        fruit.eat();
    }
}

@Target(value=ElementType.TYPE)//注解元:指定注解可以修饰类\接口\枚举
@Retention(RetentionPolicy.RUNTIME)//注解元:指定注解保存在class文件中,可以被JVM获取

@interface MyAnnotation1{
    //通过注解简化编程,方便的获取到需要的反射对象
  public   Class<?> target();
}
interface IFruit{
    void eat();
}
class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

@MyAnnotation1(target = Apple.class)//获取Apple的反射对象
class Factory{
    public static <T> T getInstance() throws IllegalAccessException, InstantiationException {
        MyAnnotation1 mt=Factory.class.getAnnotation(MyAnnotation1.class);
        return (T)mt.target().newInstance();
    }
}