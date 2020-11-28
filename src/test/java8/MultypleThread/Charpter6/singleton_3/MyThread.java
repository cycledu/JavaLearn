package java8.MultypleThread.Charpter6.singleton_3;


/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:13
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
