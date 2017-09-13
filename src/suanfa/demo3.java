package suanfa;
import java.util.*;
import java.lang.String;
/**
 * Created by 胖大星 on 2017/6/5.
 * 可能有多组测试数据，对于每组数据，
 按照样例输出的格式将字符出现的位置标出。
 1、下标从0开始。
 2、相同的字母在一行表示出其出现过的位置。
 输入例子:
 abcaaAB12ab12
 输出例子:
 a:0,a:3,a:4,a:9
 b:1,b:10
 1:7,1:11
 2:8,2:12
 */
public class demo3 {
    public static void main(String[] args){
        Scanner string = new Scanner(System.in);
        while (string.hasNext()){
            String datas = string.nextLine();
            String[] dataList = new String[datas.length()];
            for (int i = 0; i<datas.length();i++){
               dataList[i] = String.valueOf(datas.charAt(i));
            }
              for (int m = 0; m<dataList.length; m++){
                for (int n = m+1; n<dataList.length; n++){
                    if (dataList[m] == dataList[n]){
                        //System.out.println(dataList[]);
                    }
                }
              }
        }
    }
}
