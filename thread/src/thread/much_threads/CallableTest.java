package thread.much_threads;

import java.util.concurrent.*;

/**
 * Author:sweet
 * Created:2019/1/9
 */
public class CallableTest implements Callable<String> {
private int tick=10;
    @Override
    public String call() throws Exception {
        while(this.tick>0){
            System.out.println(Thread.currentThread().getName()+"剩余："+this.tick--+"张票");
        }
        return "票卖完了";
    }

    public static void main(String[] args) {
        Callable<String> callable=new CallableTest();
        FutureTask<String> futureTask=new FutureTask<String>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            //获取任务返回结果（任务结束）
          //  String result=  futureTask.get();

            //超过一秒未返回结果则抛出异常
            String result=  futureTask.get(1,TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
