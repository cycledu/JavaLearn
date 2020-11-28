package java8.MultypleThread.Charpter6.singleton_3;

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
            if (myObject != null) {
                return myObject;
            } else {
                Thread.sleep(3000);
                //使用 synchronized (MyObject.class)，虽然部分代码被锁上，
                //但还是有非线程安全问题
                //多次创建MyObject类的对象，并不是单例的效果
                synchronized (MyObject.class) {
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
