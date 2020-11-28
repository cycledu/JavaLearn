package java8.MultypleThread.Charpter6.singleton_9;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/15:45
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject.connectionFactory.getConnection().hashCode());
        }
    }
}
