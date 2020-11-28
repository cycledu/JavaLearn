package java8.MultypleThread.Charper3.joinMoreTest;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/14:13
 * @Description :
 * @Page or WebSite：P269
 * @Expected result ：
 */
public class ThreadB extends Thread {
    @Override
    synchronized public void run() {
        try {
            System.out.println("begin B ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("en B ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
