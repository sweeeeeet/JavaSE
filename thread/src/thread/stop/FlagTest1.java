package thread.stop;

/**
 * Author:sweet
 * Created:2019/1/15
 */
public class FlagTest1 {
    public static void main(String[] args) throws InterruptedException {
        MyThead myThead=new MyThead();
        Thread thread=new Thread(myThead,"子线程A");
        thread.start();
        Thread.sleep(1000);
        myThead.setFlag(false);//改变中断标记，使线程停止
        System.out.println("代码结束");
    }
}
class MyThead implements Runnable{
private boolean flag=true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i=1;
        while(flag){
            try {
                Thread.sleep(1000);
                System.out.println("第"+i++ +"次执行，线程名称为"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
