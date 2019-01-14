package synchronized_practice.object;

/**
 * Author:sweet
 * Created:2019/1/10
 */
public class StaticSynchronized2 {
    public static void main(String[] args) {

        for(int i=0;i<3;i++){

            Thread thread=new Thread(new MyRunnable2());
            thread.start();
        }
    }
}

class  MyRunnable2 implements  Runnable{

    @Override
    public void run() {
        Syn1 syn=new Syn1();
        syn.test();
    }
}

class Syn2{
    public  synchronized void test(){
        synchronized (Syn.class){
            System.out.println(Thread.currentThread().getName()+ "方法开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "方法结束");
        }
    }
}
