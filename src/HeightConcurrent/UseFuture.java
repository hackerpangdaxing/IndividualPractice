package HeightConcurrent;

import java.util.concurrent.*;

/**
 * Created by 胖大星 on 2017/9/16.
 * 适用场景：Future模式非常适合在处理很耗时很长的业务逻辑时进行使用，
 * 可以有效的减小系统的响应时间，提高系统的吞吐量。
 */
public class UseFuture implements Callable<String>{

    private String para;

    public UseFuture(String para) {
        this.para = para;
    }
    //这里是真实的业务逻辑，其执行可能很慢
    @Override
    public String call() throws Exception {
        //模拟执行耗时
        Thread.sleep(5000);
        String result = this.para + "处理完毕";
        return result;
    }

    //主控函数
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String queryStr = "query";
        //构造FutureTask，并且传入需要真正进行业务逻辑处理的类，让该类实现Callable接口
        FutureTask<String> future1 = new FutureTask<>(new UseFuture(queryStr));
        FutureTask<String> future2 = new FutureTask<>(new UseFuture(queryStr));
        //创建一个固定线程的线程池，并且线程数为1
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //这里提交任务future，则开启线程执行RealData的call方法执行
        //submit与execute的区别是：第一点submit可以传入实现Callable接口的实例对象
        //第二点是submit有返回值 execute没有返回值

        //f1.get() 返回null 说明线程执行完毕
        Future f1 = executor.submit(future1);  //单独启动一个线程去执行
        Future f2 = executor.submit(future2);

        System.out.println("请求完毕！");

        try {
            //这里可以额外进行数据操作，也就是程序执行其他的业务逻辑
            System.out.println("处理实际的业务逻辑。。。。。。");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //利用两个线程同时处理，并行操作
        //调用获取数据方法，如果call（）方法没有执行完成，则依然会进行等待
        System.out.println("数据："+future1.get());
        System.out.println("数据："+future2.get());

        executor.shutdown();
    }
}
