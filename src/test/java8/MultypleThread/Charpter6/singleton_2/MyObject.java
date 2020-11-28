package java8.MultypleThread.Charpter6.singleton_2;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:23
 * @Description :
 * @Page or WebSite：P389
 * @Expected result ：
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {
    }
    public static MyObject getInstance() {
        try {
            if (myObject != null) {
                return myObject;
            } else {
                Thread.sleep(300);
                myObject = new MyObject();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
