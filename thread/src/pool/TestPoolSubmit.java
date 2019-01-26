package pool;

import java.util.concurrent.*;

/**
 * Author:sweet
 * Created:2019/1/14
 */
public class TestPoolSubmit{
    public static void main(String[] args) {
        Callable callable=new MyCall();//创建线程实现类

                                                      //核心线程数    最大线程数           线程活动保持时间
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3,5,1000,
                //线程活动保持时间的单位   饱和策略
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
        for(int i=0;i<5;i++){
            Future<String> future = pool.submit(callable);//利用Future对象接收
            try {
                //通过get（time）方法获取返回值,若指定时间为获取到则返回
                //get()方法会等到任务执行完为止。
                String str= future.get(1000,TimeUnit.MILLISECONDS);
            System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }
}

class MyCall implements Callable {


    @Override
    public Object call() throws Exception {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
        }
        return Thread.currentThread().getName()+"任务执行完毕";
    }
}