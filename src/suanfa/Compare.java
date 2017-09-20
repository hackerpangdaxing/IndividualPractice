package suanfa;

import java.util.Vector;

/**
 * Created by 胖大星 on 2017/9/13.
 */
public class Compare {
    public static void main(String[] args) {
//        baseType();
        Compare compare = new Compare();
//        compare.baseType();
        compare.compareTo();

    }

    public void compareTo(){
        Vector vector1 = new Vector();
        Vector vector2 = new Vector();
        vector2 = vector1;
        vector1 = null;
        System.out.println("vector1 :" +vector1+ "     vector2: "+vector2);   //[]   null
        System.out.println(vector1 == vector2);   //false
    }


    public  void baseType(){
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
