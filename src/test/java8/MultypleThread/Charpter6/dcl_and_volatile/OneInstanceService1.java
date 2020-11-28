package java8.MultypleThread.Charpter6.dcl_and_volatile;

import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/14:43
 * @Description :
 * @Page or WebSite：P397
 * @Expected result ：
 */
public class OneInstanceService1 {
    public int i_am_has_state = 0;
    private volatile static OneInstanceService1 test;
    private OneInstanceService1() {
        i_am_has_state = new Random().nextInt(200) + 1;
    }
    public static OneInstanceService1 getTest() {
        if (test == null) {
            synchronized (OneInstanceService1.class) {
                if (test == null)
                    test = new OneInstanceService1();
            }
        }
        return test;
    }
    public static void reset() {
        test = null;
    }
}
