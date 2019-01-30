package thread.thread_method;

import java.time.LocalDateTime;

/**
 * Author:sweet
 * Created:2019/1/9
 */
public class ThreadMethodSleep {
    public static void main(String[] args) {
        //休眠 sleep，让当前线程阻塞
        //最简洁的写法
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("执行时间" + LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1").start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+ "执行时间" + LocalDateTime.now());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable,"线程2").start();
        new Thread(runnable,"线程3").start();


        //yiled方法 让当前线程回到就绪状态

    }
}
