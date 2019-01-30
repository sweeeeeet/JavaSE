package thread.thread_method;

/**
 * Author:sweet
 * Created:2019/1/9
 */
class  MyRunnable implements Runnable{
    private int tick=1000;

    @Override
    public void run() {
        while(tick>0){
            System.out.println(Thread.currentThread().getName()+"tick="+tick--);
        }
    }
}

public class ThreadMethodJoin {
    public static void main(String[] args) {
    MyRunnable runnable=new MyRunnable();

    //线程
    Thread thread=new Thread(runnable,"thread-A");
    thread.start();

    //在主线程中调用线程的join方法会阻塞主线程，直到调用线程对象的run方法执行完毕，主线程才会继续执行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("当前线程"+Thread.currentThread().getName());//主线程


    }
}
