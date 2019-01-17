package synchronized_practice.object.lock;

/**
 * Author:sweet
 * Created:2019/1/11
 */
public class DeadLock {
    private  static Book book=new Book();
    private static  Pen pen=new Pen();

    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (book) {
                    System.out.println(Thread.currentThread().getName() + "我有书，但是还在用");

                    synchronized (pen) {
                        System.out.println(Thread.currentThread().getName() + "我想做笔记，但是没有笔，给我");

                    }
                }
            }
        },"Thread-A");
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pen) {
                    System.out.println(Thread.currentThread().getName() + "我有笔，但是在用");

                    synchronized (book) {
                        System.out.println(Thread.currentThread().getName() + "想看书，但是没有");
                    }
                }
            }
        },"Thread-B");
thread.start();
thread2.start();
    }
}

class Pen{
    private String name = "笔";

    public String getName() {
        return name;
    }
}
class Book {
    private String name = "书";

    public String getName() {
        return name;
    }
}