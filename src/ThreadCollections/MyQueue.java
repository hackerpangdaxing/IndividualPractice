package ThreadCollections;

import sun.applet.Main;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 胖大星 on 2017/9/12.
 * 多线程模拟Queue阻塞现象
 * 实现LinkedBlockQueue下面的put和take方法  模仿队列阻塞
 */
public class MyQueue {
    //承装元素的集合
    private LinkedList list = new LinkedList();
    //计数器初始值为0
    private AtomicInteger count = new AtomicInteger(0);
    //限制容量的最大最小值
    private final int minSize = 0;
    private final int maxSize;

    //构造方法
    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }
    //锁
    private final Object lock = new Object();

    //向队列中添加元素，如果队列满了 则阻塞唤醒take方法
    public void put(Object obj){
        synchronized (lock){
            //判断队列是否满了
            while (count.get() == this.maxSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(obj);
            count.incrementAndGet();//自增
            System.out.println("新加入的元素为： "+obj);
            lock.notify();
        }
    }
    //删除队列第一个元素，如果队列为空 则阻塞 唤醒put方法
    public Object take(){
        Object res = null;

        synchronized (lock){
            //判断队列是为空
            while (count.get() == this.minSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            res = list.removeFirst();
            count.decrementAndGet();//自减
            lock.notify();
        }

        return res;
    }

    public int getSize( ){
        return this.count.get();
    }

    public static void main(String[] args) {
        final MyQueue myQueue = new MyQueue(5);
        myQueue.put("a");
        myQueue.put("b");
        myQueue.put("c");
        myQueue.put("d");
        myQueue.put("e");
        System.out.println("当前队列长度： "+myQueue.getSize());
        new Thread(new Runnable() {
            @Override
            public void run() {
                myQueue.put("f");
                myQueue.put("g");
            }
        },"t1").start(); new Thread(new Runnable() {
            @Override
            public void run() {
                Object o1 = myQueue.take();
                System.out.println("当前移除的元素为： "+o1);
                Object o2 = myQueue.take();
                System.out.println("当前移除的元素为： "+o2);
            }
        },"t2").start();
    }
}
