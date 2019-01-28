package thread.thread_leval;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class PriorityTest {
   //优先级具有继承性
    public static void code1() {
        //主线程优先级
        System.out.println("主线程的优先级"+Thread.currentThread().getPriority());
        //在主线程中创建线程不指定优先级
        Thread thread=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"的优先级是"+Thread.currentThread().getPriority());
        },"线程A");
        thread.start();
        // thread.setPriority(1);
    }
    public static void main(String[] args) {
        //验证是否优先级低的后执行
        Runnable runnable=new PriorityRunnable();
        Thread thread = new Thread(runnable, "Thread-A");
        thread.setPriority(Thread.MAX_PRIORITY);

        Thread thread1 = new Thread(runnable, "Thread-B");
        thread1.setPriority(Thread.NORM_PRIORITY);

        Thread thread11= new Thread(runnable, "Thread-C");
        thread11.setPriority(Thread.MIN_PRIORITY);

        thread11.start();
        thread.start();
        thread1.start();

    }
}

class PriorityRunnable implements Runnable{

    @Override
    public void run() {
        Thread thread=Thread.currentThread();
        System.out.println(thread.getName()+"优先级是"+thread.getPriority());
    }
}
