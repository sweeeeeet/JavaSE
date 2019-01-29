package thread.thread_leval;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class ShouHuThread {
    public static void main(String[] args)  {
        //主线程是用户线程
        //System.out.println(Thread.currentThread().isDaemon());//falase

        Thread thread = new Thread(new DeamonRunn(), "线程-A");
        //必须在start前调用
        thread.setDaemon(true);
        thread.start();

        Thread thread1 = new Thread(new DeamonRunn(), "Thread-B");
        thread1.start();
        //主线程休眠
        try {
            Thread.sleep(3000);
            //B是用户线程，还有主线程是用户线程，当所有用户线程都终止守护线程才会终止
            thread1.interrupt();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //主线程

    }
}
class DeamonRunn implements  Runnable{

    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(Thread.currentThread().getName()+"调用第"+ ++i+"次");
            try {
                System.out.println("线程名称：" + Thread.currentThread().getName()
                        + ",i=" + i + ",是否为守护线程:"
                        + Thread.currentThread().isDaemon());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("线程名称：" + Thread.currentThread().getName() + "中断线程 了");
                e.printStackTrace();
            }
        }
    }
}