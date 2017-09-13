package ThreadCollections;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胖大星 on 2017/9/12.
 */
public class ListAdd {
   private volatile static  List list = new ArrayList();

   public void addList(){
       list.add("hello");
   }

   public int size(){
       return list.size();
   }

   public static void main(String[] agrs){
       final ListAdd list1 = new ListAdd();
       Object lock = new Object();
       Thread thread = new Thread(new Runnable(){
           @Override
           public void run() {
                   try {
                       synchronized (lock){
                           for (int i = 0; i < 10; i++) {
                               list1.addList();
                               System.out.println("当前线程为： "+Thread.currentThread().getName()+"  "+i);
                               Thread.sleep(500);
                               if(list.size() == 5){
                                   System.out.println("当前通知已发出！");
                                   lock.notify();
                               }
                           }
                       }
                   }
                   catch (InterruptedException e){
                        e.printStackTrace();
                   }
           }
       },"t1");

       Thread thread2 = new Thread(new Runnable() {
           @Override
           public void run() {
               synchronized (lock) {
                   if (list1.size() != 5) {
                       try {
                            lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   System.out.println("当前线程：" + Thread.currentThread().getName()+"已经收到通知");
                   throw new RuntimeException();
               }
           }
       },"t2");

       thread2.start();
       thread.start();

   }
}
