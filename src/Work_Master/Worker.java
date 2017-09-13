package Work_Master;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by 胖大星 on 2017/9/13.
 */
    //每个worker必须要实现Runnable接口
public class Worker implements Runnable{
    //每一个worker对象都需要master的ConcurrentHashMap的引用
    private ConcurrentHashMap<String,Object> resultMap;
    //每一个worker对象都需要master的ConcurrentLinkedQueue的引用
    private ConcurrentLinkedQueue<Task> workerQueue;

    public void setWorkerQueue(ConcurrentLinkedQueue<Task> workerQueue) {
        this.workerQueue = workerQueue;
    }

    public void setResultMap(ConcurrentHashMap<String,Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true){
            Task input = this.workerQueue.poll();
            if (input == null) break;
            //真正去做业务处理   可以利用MyWorker在此执行多个业务
            Object output = MyWorker.handle(input);

            this.resultMap.put(Integer.toString(input.getId()),output);
        }
    }
    //用于子类继承，增强解耦
    public static Object handle(Task input) {

        return null;
    }
}
