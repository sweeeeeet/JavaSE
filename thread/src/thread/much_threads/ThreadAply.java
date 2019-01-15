package thread.much_threads;

/**
 * Author:sweet
 * Created:2019/1/9
 */
class Thread3 extends Thread{
    private static int tick=10;
    @Override
    public void run() {
        while(this.tick>0){
            System.out.println(this.getName()+"剩余："+this.tick--+"张票");
        }
    }
}
public class ThreadAply {
    public static void main(String[] args) {
        Thread3 thread1=new Thread3();
        thread1.setName("Thread-A");
        Thread3 thread2=new Thread3();
        thread2.setName("Thread-B");
        thread1.start();
        thread2.start();
    Runnable runnable=new Runnable() {
        private int ticket=10;
        @Override
        public void run() {
            while(ticket>0){
                System.out.println(Thread.currentThread()+ "剩余："+ticket--+"张票");
            }
        }
    };
    new Thread(runnable,"线程一").start();
    new Thread(runnable,"线程二").start();
    }
}
