package suanfa;

import java.util.*;
/**
 * Created by 胖大星 on 2017/6/4.
 * N 阶楼梯上楼问题：一次可以走两阶或一阶，问有多少种上楼方式。（要求采用非递归）
 输入描述:
 输入包括一个整数N,(1<=N<90)。
 */
public class demo1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            long[] fab = new long[n+1];
            fab[0] = 0;
            if(n > 0){
                fab[1] = 1;
            }
            if(n > 1){
                fab[2] = 2;
            }
            for(int i = 3; i <= n; i++){
                fab[i] = fab[i-1] + fab[i-2];
            }
            System.out.println(fab[n]);

        }

    }
}
