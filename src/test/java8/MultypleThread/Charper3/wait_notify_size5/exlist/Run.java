package java8.MultypleThread.Charper3.wait_notify_size5.exlist;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/23:23
 * @Description :
 * @Page or WebSite：P197
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
