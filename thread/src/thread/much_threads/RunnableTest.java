package thread.much_threads;

/**
 * Author:sweet
 * Created:2019/1/9
 */

class MyThread1 implements Runnable{
    @Override
    public void run() {

    }
    String name;
    public MyThread1(String name) {
        this.name=name;
    }

}
public class RunnableTest {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1("线程1");
        MyThread1 myThread1 = new MyThread1("线程2");
        MyThread1 myThread2 = new MyThread1("线程3");
      //1.通过Thread的构造方法执行
        new Thread(myThread).start();
        new Thread(myThread1).start();
        new Thread(myThread2).start();

        //2.匿名内部类
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("hello,new thread");
            }
        };
        new Thread(runnable).start();

        //3.lambda表达式
        new Thread(
                ()-> System.out.println("hello new thread")
        ).start();
    }
}
