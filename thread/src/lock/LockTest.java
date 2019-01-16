package lock;

import org.omg.CORBA.TRANSACTION_MODE;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * Author:sweet
 * Created:2019/1/13
 */
public class LockTest {
    public static void main(String[] args) {
        Lock lock=new Mutex();
        Lock lock1=new ReentrantLock();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(()->{
                try{
                    lock.lock();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}

//自定义锁
class Mutex implements Lock{
    private Sync sync=new Sync();
    //AQS实现Lock的方法，自定义同步器
    static class  Sync extends AbstractQueuedSynchronizer {
        @Override
        //尝试获取锁
        protected boolean tryAcquire(int arg) {
           //0表示无锁
            if(arg!=1){
                throw new RuntimeException("arg参数不为1");
            }
            //CAS(0,1),若当前状态为0，则，用CAS将其置换为1，再把当前线程扔进去
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return  true;
            }

            return false;
        }

        @Override
        //释放共享
        protected boolean tryReleaseShared(int arg) {
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        //判断当前线程是否是持有线程
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
    }
//----------------------------------------------------------------
    @Override
    public void lock() {
       //调用acquire上锁
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
    //------------------------------------------------------------------
}
