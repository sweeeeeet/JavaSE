package thread.much_threads;

/**
 * Author:sweet
 * Created:2019/1/9
 */

class MyThread extends Thread{
    String name;
    public MyThread(String name) {
       this.name=name;
    }
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(this.name+i);
        }
    }
}
public class ThreadTest {
   //主线程
    public static void main(String[] args) {
        MyThread myThread = new MyThread("线程1");
        MyThread myThread1 = new MyThread("线程2");
        MyThread myThread2 = new MyThread("线程3");
        myThread.start();
        myThread2.start();
        myThread1.start();

    }
}
