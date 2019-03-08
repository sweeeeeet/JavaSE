package threadlocal;

/**
 * Author:sweet
 * Created:2019/1/11
 */
public class Test {
    //多线程共享
    private static String staticValue;
   //多线程独立
    private static ThreadLocal<String> threadLocal =new ThreadLocal<>();
    //jdk1.8提供的初始化方法
    //private static ThreadLocal<String> threadLocal1 = ThreadLocal.withInitial(() -> "HELLO");
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return "hello";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        //main是主线程指向
        //在主线程中修改staticValue
        staticValue="主线程中的值";
        threadLocal.set("主线程修改后的值");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                staticValue="子线程中的值";
                threadLocal.set("子线程修改后的值");
                System.out.println(threadLocal.get());
            }
        },"子线程");
        thread.start();
        thread.join();

        System.out.println(staticValue);//主线程中的值
        System.out.println(threadLocal.get());//子线程修改后的值
    }
}
