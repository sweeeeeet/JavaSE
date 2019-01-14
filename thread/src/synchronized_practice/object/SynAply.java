package synchronized_practice.object;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class SynAply implements Runnable{
       private Sync sync;
      public  SynAply(Sync sync){
          this.sync=sync;
      }
    @Override
    public void run() {
          //因为synchronized是对象锁，因此只能有一个对象进入当前方法
        sync.testA();
        sync.testB();
    }

    public static void main(String[] args) {
        Sync sync=new Sync();
        Runnable synAply=new SynAply(sync);
        Thread threadA=new Thread(synAply,"A");
        Thread threadB=new Thread(synAply,"B");
        threadA.start();
        threadB.start();

    }
}
class Sync{
    public synchronized void  testA(){
        //只有名为A的线程才能执行此方法
        if(Thread.currentThread().getName().equals("A")){
            while(true){

            }
        }
    }
    public synchronized void testB(){
        //只有名为B的线程才能执行此方法
        if(Thread.currentThread().getName().equals("B")){
            System.out.println("线程B打印此方法");
        }
    }



}
