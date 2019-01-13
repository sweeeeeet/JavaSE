package synchronized_practice.object;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class ObjSynchronized {
    public static void main(String[] args) {
        Syn syn=new Syn();
        for(int i=0;i<3;i++){
        Runnable runnable=new MyRunnable(syn);
            Thread thread=new Thread(runnable);
            thread.start();
        }
    }
}
class  MyRunnable implements  Runnable{
private Syn syn;
public MyRunnable(Syn syn){
    this.syn=syn;
}
    @Override
    public void run() {
       this.syn.test();
    }
}
class Syn{
    public synchronized void test(){
        System.out.println(Thread.currentThread().getName()+ "方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "方法结束");
    }
}
