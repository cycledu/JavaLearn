package java8.MultypleThread.Charpter6.singleton_2_2;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:28
 * @Description :
 * @Page or WebSite：P392
 * @Expected result ：
 */
public class MyObject {
    private static MyObject myObject;
    private MyObject() {

    }
    public static MyObject getInstance() {
        try {
            //此种写法等同与：
            //synchronized public static MyObject getInstance(),效率一样很低
            synchronized (MyObject.class) {
                if (myObject != null) {
                    return myObject;
                } else {
                    Thread.sleep(3000);
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
