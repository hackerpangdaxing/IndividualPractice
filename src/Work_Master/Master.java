package Work_Master;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by 胖大星 on 2017/9/13.
 */
public class Master {
    //1.应该有一个承装任务的集合
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<Task>();
    //2.使用HashMap去承装所有的work对象
    private HashMap<String,Thread> workers = new HashMap<String,Thread>();
    //3.使用一个容器承装每一个work并非执行任务的结果集
    private  ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<String,Object>();

    //4.构造方法
    public Master(Worker work, int workerCount){
        //每一个worker对象都需要有Master的引用workQueue用于任务的领取，resultMap用于任务的提交
        work.setWorkerQueue(this.workQueue);
        work.setResultMap(this.resultMap);
        for (int i = 0; i < workerCount; i++) {
            //key表示每一个worker的名字，value表示线程执行对象
             workers.put("子节点： " + Integer.toString(i), new Thread(work));

        }
    }
    //5.提交方法
    public void submit(Task task){
        this.workQueue.add(task);
    }

    //6.需要一个执行的方法（启动应用程序让所有的worker工作）
    public void execute(){
        for (Map.Entry<String, Thread> me: workers.entrySet()){
            me.getValue().start();
        }
    }

    //判断线程是否执行完毕
    public boolean isComplete(){
        for (Map.Entry<String,Thread> me : workers.entrySet() ) {
            if (me.getValue().getState() != Thread.State.TERMINATED)
                return false;
        }
        return true;
    }

    //返回结果集数据
    public int getResult(){
        int ret = 0;
        for (Map.Entry<String, Object> me : resultMap.entrySet()) {
            //汇总的逻辑。。。
            ret += (Integer)me.getValue();

        }
        return ret;
    }
}
