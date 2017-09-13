package Work_Master;

import java.util.Random;

/**
 * Created by 胖大星 on 2017/9/13.
 */
public class Main {
    public static void main(String[] args) {
        //Runtime.getRuntime().availableProcessors() 可自定义执行线程数
        Master master = new Master(new MyWorker(),Runtime.getRuntime().availableProcessors());
        System.out.println("当前计算机可用线程数量："+Runtime.getRuntime().availableProcessors());
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Task t = new Task();
            t.setId(i);
            t.setName("task: " + i);
            t.setPrices(random.nextInt(1000));
            master.submit(t);
        }
        master.execute();
        long start = System.currentTimeMillis();

        while (true){
            if (master.isComplete())
            {
                long end = System.currentTimeMillis() - start;
                int ret = master.getResult();
                System.out.println("最终结果为： " +ret + ", 执行耗时： "+end);
                break;
            }
        }
    }
}
