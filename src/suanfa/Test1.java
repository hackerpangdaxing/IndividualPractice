package suanfa;

/**
 * Created by 胖大星 on 2017/9/4.
 */
public class Test1 {
    public static void main(String [] args){
        //choose();
        String str = "abc";
        System.out.println(str);
        str = "1";
        System.out.println(str);
    }

    public static int choose(){
        int m ;
        for(m = 1; m < 10;){
            m += m;
            System.out.println(m);
            return 0;
        }
        return m;
    }
}
