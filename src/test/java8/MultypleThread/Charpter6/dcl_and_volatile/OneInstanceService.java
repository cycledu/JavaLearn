package java8.MultypleThread.Charpter6.dcl_and_volatile;

import java.util.Random;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/14:43
 * @Description :
 * @Page or WebSite：P397
 * @Expected result ：
 */
public class OneInstanceService {
    public int i_am_has_state = 0;
    private static OneInstanceService test;
    private OneInstanceService() {
        i_am_has_state = new Random().nextInt(200) + 1;
    }
    public static OneInstanceService getTest() {
        if (test == null) {
            synchronized (OneInstanceService.class) {
                if (test == null)
                    test = new OneInstanceService();
            }
        }
        return test;
    }
    public static void reset() {
        test = null;
    }
}
