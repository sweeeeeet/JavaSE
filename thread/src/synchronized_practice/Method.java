package synchronized_practice;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class Method {
    public static void main(String[] args) {
        Runnable runnable=new MyThread();
        Thread thread=new Thread(runnable,"黄牛1");
        Thread thread1=new Thread(runnable,"黄牛2");
        Thread thread2=new Thread(runnable,"黄牛3");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class MyThread1 implements Runnable{
private int tick=100;
    @Override
    public void run() {
        for(int i=0;i<100;i++){
           this.sale(tick);
        }
    }
    public synchronized void sale(int tick){

            if(tick>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"还剩"+this.tick--+"张票");
            }
        }

}