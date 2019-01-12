package com.sweet.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:sweet
 * Created:2019/1/8
 */
//利用队列解耦生产者消费者模型。
public class PQTest {
    public static void main(String[] args) {

        //生产者队列
        Queue<String> queue=new LinkedList<>();
        new Thread(new Runnable() {
            {
                System.out.println("生产者线程启动");

            }
            @Override
            public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    //生产数据，放入队列
                    queue.add("生产"+String.valueOf(Math.random()));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            }


        }).start();//将一个线程启动，则与主线程分离，独立于主线程执行，在此线程中可以再定义执行逻辑
        //两个线程的执行时间随机

        //消费队列
       //通过两个线程，实现消费者与生产者的分离解耦
        new Thread(new Runnable() {
            {
                System.out.println("消费者线程");
            }
            @Override
            public void run() {
            while(true){
                try {
                    Thread.sleep(1000);
                    System.out.println("消费队列"+queue.poll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            }
        }).start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
