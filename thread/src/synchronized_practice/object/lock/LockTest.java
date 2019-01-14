package synchronized_practice.object.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class LockTest {
    public static void main(String[] args) {
        Runnable runnable = new LockRunn();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}

class LockRunn implements Runnable {
    private int tick = 10;
    private Lock lock = new ReentrantLock();


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();//加锁,一般将锁加在try块之前，解锁放在finally中
            try {
                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "剩余票数" + --this.tick);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }


        }
    }
}

