package Exception;

/**
 * Created by 胖大星 on 2017/9/20.
 */
public class TestException {
    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }

    public static void DataOutSize() throws MyException {
        String[] greeting = {"hello1","hello2","hello3" };
        int i = 0;
        while (i < 4){
            try{
                System.out.println(greeting[i++]);
            }catch (ArrayIndexOutOfBoundsException e){
                //System.out.println("数组下标越界异常");
                throw new MyException("数组下标越界异常");
            }
        }
    }

    public static void main(String[] args) throws MyException {
        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            System.out.println("超出数组长度！");
            e.printStackTrace();
        }

        DataOutSize();
        System.out.println("-----------");
    }
}