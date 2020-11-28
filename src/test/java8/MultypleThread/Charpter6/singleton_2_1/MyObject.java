package java8.MultypleThread.Charpter6.singleton_2_1;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:28
 * @Description :
 * @Page or WebSite：P390
 * @Expected result ：
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {

    }
    //将整个获取实例的方法上锁,缺点是效率低
    synchronized public static MyObject getInstance() {
        try {
            if (myObject != null) {
                return myObject;
            } else {
                Thread.sleep(3000);
                myObject = new MyObject();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
