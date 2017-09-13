package ThreadCollections;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 胖大星 on 2017/9/12.
 */
public class VolatileNoAtomic extends Thread{
    //private static volatile int count; //只是实现了线程内的可见性
    private  static AtomicInteger count = new AtomicInteger(0); //体现原子性 ， 建议使用
    private static void addCount(){
        for (int i = 0; i < 1000; i++) {
            //count++;
            count.incrementAndGet(); //等价于 ++
        }
        System.out.println(count);
    }

    public void run(){
        addCount();
    }

    public static void main(String[] agrs){
        VolatileNoAtomic[] v = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            v[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < 10; i++) {
            v[i].start();
        }
    }
}
