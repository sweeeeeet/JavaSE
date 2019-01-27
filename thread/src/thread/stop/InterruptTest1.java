package thread.stop;

/**
 * Author:sweet
 * Created:2019/1/15
 */
class MyRun implements Runnable{
private boolean flag=true;


    @Override
    public void run() {
        int i=1;
        while(flag){
            try{
                Thread.sleep(1000);
                boolean bool=Thread.currentThread().isInterrupted();//false
                System.out.println(bool);
                if(bool){//中断执行
                    System.out.println("非阻塞中断情况下执行该操作"+bool);
                    break;
                }
                System.out.println(Thread.currentThread().getName()+ "第"+i+"次执行");
                i++;
            } catch (InterruptedException e) {
                System.out.println("退出了");
                //这里退出阻塞状态，且中断标志被系统自动清除
                //重新设置为false,因此此处bool为false
                boolean bool=Thread.currentThread().isInterrupted();
                System.out.println(bool);
                return;
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class InterruptTest1 {
    public static void main(String[] args) throws InterruptedException {
        MyRun myRun=new MyRun();
        Thread thread=new Thread(myRun,"子线程A");
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();//调用此方法，只是将中断标志设为true
        //设为true后，若还调用了sleep、wait、join方法，线程会抛异常
        //此时中断标志清除，设为false
        System.out.println("代码结束");
    }
}
