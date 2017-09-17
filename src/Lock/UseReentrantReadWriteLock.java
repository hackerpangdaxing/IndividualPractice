package Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 胖大星 on 2017/9/17.
 * lock的读写锁  适用于 读多写少的场景 效率较高
 */
public class UseReentrantReadWriteLock {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public void read(){
        try {
            readLock.lock();
            System.out.println("当前线程："+Thread.currentThread().getName()+"进入....");
            Thread.sleep(3000);
            System.out.println("当前线程："+Thread.currentThread().getName()+"退出....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public void write(){
        try {
            writeLock.lock();
            System.out.println("当前线程："+Thread.currentThread().getName()+"进入....");
            Thread.sleep(3000);
            System.out.println("当前线程："+Thread.currentThread().getName()+"退出....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        UseReentrantReadWriteLock useReentrantReadWriteLock = new UseReentrantReadWriteLock();
        Thread threadRead1 = new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantReadWriteLock.read();
            }
        }, "threadRead1");
      Thread threadRead2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    useReentrantReadWriteLock.read();
                }
            }, "threadRead2");

        Thread threadWrite1 = new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantReadWriteLock.write();
            }
        }, "threafWrite1");

        Thread threadWrite2 = new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantReadWriteLock.write();
            }
        }, "threafWrite2");

        //两个读线程同时开始 ，写线程明显较慢
        threadRead1.start();
       // threadRead2.start();
        threadWrite1.start();
      //  threadWrite2.start();
    }
}
