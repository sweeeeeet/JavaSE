package pc;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * Author:sweet
 * Created:2019/1/21
 */
public class ConditionPC {
    public static void main(String[] args) {
        GoodsC goodsC = new GoodsC(20);
        Produce produce = new Produce(goodsC);
        Consumers consumers = new Consumers(goodsC);
        List<Thread> list = new ArrayList<>();
        //启动10个消费者线程
        for(int i=0;i<10;i++){
            Thread thread=new Thread(consumers,"消费者"+i);
            list.add(thread);
        }
        //启动5个消费者
        for(int i=0;i<5;i++){
            Thread thread=new Thread(produce,"生产者"+i);
            list.add(thread);
        }
        //一键启动
        for(Thread th:list){
            th.start();
        }
    }
}
class GoodsC{
    private String name;
    private int count;
    private int maxCount;
    private Lock lock=new ReentrantLock();
    //消费者等待队列
    private Condition consumerCondition=lock.newCondition();
    //生产者等待队列
    private  Condition producerConditon=lock.newCondition();
    //设置商品名称
    public void setGoods(String name){
        lock.lock();
        try {
            //当商品达到数量最大值，生产者线程进入生产者等待队列
            while (count == maxCount) {
                try {
                    System.out.println(Thread.currentThread().getName()+"还有很多商品，歇会~");
                    producerConditon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName()+"生产"+toString());
            //唤醒处于消费队列的线程
            consumerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }
public void getGoods(){
        try{
            lock.lock();
            while (count==0){
                System.out.println(Thread.currentThread().getName()+"还没有商品");
                try {
                    consumerCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+toString());
            //唤醒所有生产者线程
            producerConditon.signalAll();
        }finally {

        }
}
    @Override
    public String toString() {
        return "GoodsC{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public GoodsC(int maxCount) {
        this.maxCount = maxCount;
    }
}
class Produce implements Runnable {
    private GoodsC goodsC;

    public Produce(GoodsC goodsC) {
        this.goodsC = goodsC;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            this.goodsC.setGoods("纪梵希限量");

        }
    }
}
class Consumers implements Runnable{
    private GoodsC goodsC;

    public Consumers(GoodsC goodsC) {
        this.goodsC = goodsC;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
        this.goodsC.getGoods();
        }

    }
}
