package thread.stop;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class FlagTest {
    public static void main(String[] args) throws InterruptedException {
     //使用标记位方式停止线程
        Runnable runnable=new MyRunnable();
        Thread thread = new Thread(runnable, "标记线程");
        thread.start();
        Thread.sleep(3000);//主线程休眠3秒
      //修改标记位
       // ((MyRunnable) runnable).setFlag(false);

        //使用stop强制停止
        thread.stop();

    }
}
class MyRunnable implements Runnable{
   private boolean flag=true;
    @Override
    public void run() {
            int i=0;
        while(this.flag){
            try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"第"+ ++i+"次执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}