package factory;

import java.lang.reflect.Method;

/**
 * Author:sweet
 * Created:2019/1/23
 */
interface MethodInterceptor{

}
public class CGLIBProxy {

}
class Message{
    public void send(){
        System.out.println("reflect");
    }
}
class ClassProxy implements MethodInterceptor {
    private Object target;

    public ClassProxy(Object target) {
        this.target = target;
    }

    public void afterHandle() {
        System.out.println("[CGLIBProxy]方法处理后");
    }

    public void beforeHandle() {
        System.out.println("[CGLIBProxy]方法处理前");
    }
}


