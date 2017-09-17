package Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 胖大星 on 2017/9/17.
 * Lock 比 synchronized 方法更加便捷，灵活
 */
public class UseReentrantLock {
    //new ReentrantLock(false) 可以带参数 false 表示非公平锁（根据cpu分配优先执行） true表示公平锁（先来先执行）
    private ReentrantLock lock = new ReentrantLock();
    public void method1(){
        try {
            lock.lock();
            System.out.println("当前线程："+Thread.currentThread().getName()+"进入method1...");
            Thread.sleep(1000);
            System.out.println("当前线程："+Thread.currentThread().getName()+"退出method1...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void method2(){
        try {
            lock.lock();
            System.out.println("当前线程："+Thread.currentThread().getName()+"进入method2...");
            Thread.sleep(1000);
            System.out.println("当前线程："+Thread.currentThread().getName()+"退出method2...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        UseReentrantLock useReentrantLock = new UseReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantLock.method1();
                useReentrantLock.method2();
            }
        }, "t1");

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
