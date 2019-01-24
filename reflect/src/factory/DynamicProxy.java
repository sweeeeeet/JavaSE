package factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:sweet
 * Created:2019/1/22
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Isubject isubject= (Isubject) new ProxySubject().bind(new RealSubject());
        isubject.eat("麻辣烫",2);
    }
}

interface Isubject {//核心接口

    public void eat(String name, int num);
}

class RealSubject implements Isubject {

    @Override
    public void eat(String name, int num) {
        System.out.println("我要吃" + num + "分量的" + name);
    }
}

//动态代理类
class ProxySubject implements InvocationHandler {
    //绑定任意接口对象，使用Object描述
    private Object target;


    @Override
    //在覆写接口的抽象方法中实现要实现的处理逻辑
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      this.preHandle();
      //invoke()实现真实对象调用
      Object ret=method.invoke(this.target,args);
      this.afterHandle();
        return ret;
    }
//在bind方法中传入真实对象，绑定真实对象，返回代理对象
    public Object bind(Object target) {
        this.target = target;
        return
                //    public static Object newProxyInstance(ClassLoader loader,
                //                                          Class<?>[] interfaces,
                //                                          InvocationHandler h)
                Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public void preHandle(){
        System.out.println("代理方法处理前");
    }
    public void afterHandle(){
        System.out.println("代理方法处理后");
    }
}