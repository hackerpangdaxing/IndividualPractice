package Work_Master;

/**
 * Created by 胖大星 on 2017/9/13.
 */
public class MyWorker extends Worker {
    //核心部分
    public static Object handle(Task input) {
        Object output = null;
        try {
            //表示处理task任务耗时，可能是数据的加工，也可能是操作数据库
            Thread.sleep(500);
            output = input.getPrices();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
