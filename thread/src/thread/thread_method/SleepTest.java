package thread.thread_method;

/**
 * Author:sweet
 * Created:2019/1/15
 */
public class SleepTest {
    public static void main(String[] args) {
        MyThread my=new MyThread();
       new Thread(my).start();
       new Thread(my).start();
       new Thread(my).start();


    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程"+Thread.currentThread().getName()+",i="+i);
        }
    }
}