package pool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author:sweet
 * Created:2019/1/14
 */
public class TestPoolExcute {
    public static void main(String[] args) {
        Runnable myrun=new MyRunn();//创建线程实现类
                                                      //核心线程数    最大线程数           线程活动保持时间
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3,5,1000,
                //线程活动保持时间的单位   饱和策略
                TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
        for(int i=0;i<5;i++){
            //用excute()方法提交不需要返回值的任务，不能判断任务是否被线程池执行成功
            pool.execute(myrun);//线程池对象调用excute()方法启动线程，不需调用start方法

        }
    }
}
class MyRunn implements  Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "+" + i);
        }
    }
}