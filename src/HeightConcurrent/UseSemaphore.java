package HeightConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 胖大星 on 2017/9/16.
 * Semaphore:可以控制系统的流量
 * 拿到信号量的线程可以进入，否则就等待，
 * 通过acquire（）和release（）获取和释放访问许可
 */
public class UseSemaphore {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            int number = i;
            System.out.println("执行任务： "+i);
            Runnable runnable = new Runnable(){

                @Override
                public void run() {
                    try {
                        //获取请求
                        semaphore.acquire();
                        System.out.println("获取许可: "+number);
                        Thread.sleep((long) (Math.random()*10000));
                        //释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
                executorService.execute(runnable);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
