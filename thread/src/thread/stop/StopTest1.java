package thread.stop;

/**
 * Author:sweet
 * Created:2019/1/15
 */
public class StopTest1 {
    public static void main(String[] args) throws InterruptedException {
        MyThead thead=new MyThead();

        Thread thread=new Thread(thead);
        thread.start();
        Thread.sleep(10000);
        thread.stop();
        System.out.println("代码结束");
    }
}
class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}