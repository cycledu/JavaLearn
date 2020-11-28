package java8.MultypleThread.Charpter6.singleton_8;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/15:38
 * @Description :
 * @Page or WebSite：P403
 * @Expected result ：
 */
public class MyObject {
    private static MyObject instance = null;
    private MyObject() {
    }
    static {
        instance = new MyObject();
    }

    public static MyObject getInstance() {
        return instance;
    }
}
