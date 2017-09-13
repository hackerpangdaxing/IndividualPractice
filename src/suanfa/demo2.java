package suanfa;
import  java.util.*;
/**
 * Created by 胖大星 on 2017/6/5.
 * 给出一个长度不超过1000的字符串，判断它是不是回文(顺读，逆读均相同)的。
 */
public class demo2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String result="";
        while (scanner.hasNext())
        {
            String string = scanner.nextLine();
            int length = string.length();
            if (length%2 == 0){
                for (int i = 0; i<= length/2 -1; i++){
                    if(string.charAt(i) != string.charAt(length-i-1)){
                        result = "No!";
                        break;
                    }
                }
            }else if (length%2 == 1){
                    for (int i = 0; i<= (length-1)/2 -1; i++){
                        if(string.charAt(i) != string.charAt(length-i-1)){
                            result = "No!";
                            break;
                        }
                    }
         }
         if (result.equals("No!"))
            System.out.println(result);
            else
             System.out.println("Yes!");
         }
    }
}
/**
 *
 import  java.util.*;
     public class Main {
         public static void main(String[] args){
                 Scanner scan=new Scanner(System.in);
                     while(scan.hasNext()){
                     String str=scan.nextLine();               
                     StringBuilder sb=new StringBuilder(str);
                     String newStr = sb.reverse().toString();
                         
                     if(str.equals(newStr)){
                         System.out.println("Yes!");
                     }else{
                         System.out.println("No!");
                     }
             }
         }
     }

 * */