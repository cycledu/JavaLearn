package java8.MultypleThread.Charpter6.singleton_5;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:28
 * @Description :
 * @Page or WebSite：P395
 * @Expected result ：
 */
public class MyObject {
    //volatile关键字使变量在多个线程间可见
    private volatile static MyObject myObject;
    private MyObject() {

    }
    public static MyObject getInstance() {
        try {
            if (myObject != null) {
                return myObject;
            } else {
                Thread.sleep(3000);
                synchronized (MyObject.class) {
                    if (myObject==null)
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
