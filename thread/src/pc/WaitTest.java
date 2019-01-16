package pc;

/**
 * Author:sweet
 * Created:2019/1/12
 */
public class WaitTest {
    public static void main(String[] args) {
//对象在主方法中创建，因为缓冲池只有一个
        Object object=new Object();

        Mythread waitThread=new Mythread(true,object);
        Mythread notifyThread1=new Mythread(false,object);
        Thread thread=new Thread(waitThread,"wait线程");
        Thread thread2=new Thread(notifyThread1,"notify线程");
        thread.start();
        thread2.start();
        System.out.println("main方法结束");
    }
}

class Mythread implements Runnable {
    private boolean flag;
    private Object object;

    public Mythread(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    public void waitMethod() {
        synchronized (object) {
            while (true) {
                System.out.println("wait方法开始" + Thread.currentThread().getName());
                try {
                    object.wait();
                    System.out.println("wait方法结束" + Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notifyMethod() {
        synchronized (object) {
            System.out.println("notify方法开始" + Thread.currentThread().getName());
            object.notify();
            System.out.println("notify方法结束" + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }
}
