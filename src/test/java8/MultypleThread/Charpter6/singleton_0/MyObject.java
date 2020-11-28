package java8.MultypleThread.Charpter6.singleton_0;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:12
 * @Description :
 * @Page or WebSite：P383
 * @Expected result ：
 */
public class MyObject {
    //立即加载方式/饿汉模式
    private static MyObject myObject = new MyObject();
    private MyObject() {
    }
    public static MyObject getInstance() {
        return myObject;
    }
}
