package suanfa;

/**
 * Created by 胖大星 on 2017/9/13.
 */
public class Compare {
    public static void main(String[] args) {
        Integer s=new Integer(9);
        Integer t=new Integer(9);
        Long u=new Long(9);
//        System.out.println(s.equals(t));   //true
//        System.out.println(s.equals(u));   //false
//        System.out.println(s==t);   //false
//        System.out.println(s.equals(new Integer(9)));//true
        int a = 9;
        System.out.println(s == t);  //false
        System.out.println(s == a);  //true
        System.out.println(u == a);  //true


    }
}
