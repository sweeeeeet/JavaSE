package thread.stop;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable=new MyRunnable2();
        Thread thread = new Thread(runnable, "标记线程");
        thread.start();
        Thread.sleep(3000);//主线程休眠3秒
     thread.interrupt();

    }
}

class MyRunnable2 implements Runnable{

    @Override
    public void run() {
            int i=0;
        while(true){
            try {
                //判断线程的终端情况
                boolean interupt=Thread.currentThread().isInterrupted();
             //非阻塞情况
                if(interupt){
                    break;
                }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"第"+ ++i+"次执行");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
                return;
            }
        }
    }


}