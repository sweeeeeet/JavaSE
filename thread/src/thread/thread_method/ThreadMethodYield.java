package thread.thread_method;

import java.time.LocalDateTime;

/**
 * Author:sweet
 * Created:2019/1/9
 */
public class ThreadMethodYield {
    public static void main(String[] args) {
        //yiled方法 让当前线程回到就绪状态
        Runnable runnable= () -> {
            for(int i=0;i<3;i++){
                Thread.yield();
                System.out.println(Thread.currentThread().getName()+"i="+i);
            }
        };

        new Thread(runnable,"线程一").start();
        new Thread(runnable,"线程三").start();
        new Thread(runnable,"线程二").start();
    }
}
