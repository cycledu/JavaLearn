package java8.MultypleThread.Charpter6.singleton_1;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:16
 * @Description :
 * @Page or WebSite：P387
 * @Expected result ：
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {
    }
    public static MyObject getInstance() {
        //延迟加载
        if (myObject != null) {
            return myObject;
        } else {
            myObject = new MyObject();
        }
        return myObject;
    }
}
