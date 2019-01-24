package factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Author:sweet
 * Created:2019/1/22
 */
public class DyProxyPractic {
    public static void main(String[] args) {
        Food food= (Food) new ProxyFood().bind(new Rice());
        food.info();
    }
}
interface Food{
void info();
}
class Rice implements Food{

    @Override
    public void info() {
        System.out.println("米饭是一种食物");
    }
}

class ProxyFood implements InvocationHandler{
private  Object target;

public Object bind(Object target){
        this.target=target;
    return
            Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

}
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       Object retVal;
        System.out.println("吃东西之前");
        retVal = method.invoke(this.target, args);
        System.out.println("吃东西之后");
        return retVal;
    }
}