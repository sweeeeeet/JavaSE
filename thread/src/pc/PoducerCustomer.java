package pc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author:sweet
 * Created:2019/1/12
 * 生产者消费者模型：
 */
public class PoducerCustomer {
    public static void main(String[] args) {
Queue<Goods> goods=new LinkedList<>();
AtomicInteger au=new AtomicInteger(0);
Object monitor=new Object();
//创建生产者
        Producer producer=new Producer(goods,monitor,au);
        Producer producer2=new Producer(goods,monitor,au);
        //创建消费者
        Customer customer = new Customer(goods, monitor);
        //创建线程启动生产者与消费者
        new Thread(producer).start();
        new Thread(producer2).start();
        new Thread(customer).start();

    }
}
class Goods{
    private final String name;

    public Goods(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                '}';
    }
}
class  Producer implements Runnable{
    //生产者将生产的商品放入缓冲池，
    //因为缓冲池是共有的，因此不能new一个实例化对象，
    // 只能通过传参的方式传入生产者的实例化对象中
        private final Queue<Goods> goods;


    // 利用对监听器对象上锁保证放入缓冲池的同步性
    //因为生产者与消费者通过对同一个对象进行控制来进行沟通，
    // 因此只能有一个实例化对象，在主类的主方法中产生
        private final  Object monitor;
    //对商品进行编号，利用原子整型保证线程安全，在多线程中不能用i++
        private  final AtomicInteger atomicInteger;

    public Producer(Queue<Goods> goods, Object monitor, AtomicInteger atomicInteger) {
        this.goods = goods;
        this.monitor = monitor;
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {
while(true){
    try {
        //通过睡眠时间控制生产者与消费者的速度
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    synchronized (monitor){
        //设定缓冲池到达10个时，生产者wait()
        //满等待
        if(this.goods.size()==10){
            try {
                this.monitor.wait();
                System.out.println("商品池满了,休息一会");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            //若未满10个，向线程池中添加商品
            Goods goods=new Goods(String.valueOf(atomicInteger.addAndGet(1)));
            this.goods.add(goods);
            System.out.println(Thread.currentThread().getName()+"生产"+goods);
        }
    }
}
    }
}
class  Customer implements Runnable{
    //缓冲队列
   private final Queue<Goods> goods;
   private final Object monitor;

    public Customer(Queue<Goods> goods, Object monitor) {
        this.goods = goods;
        this.monitor = monitor;
    }

    @Override
    public void run() {
while (true){
    try {
        //通过睡眠时间控制生产者与消费者的速度
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    synchronized (monitor){
        //空唤醒
        if(goods.isEmpty()){
            System.out.println("商品池空了,快来生产呀~~");
            monitor.notify();
        }else {
            System.out.println("消费者消费"+goods.poll());
        }
    }
}
    }
}
