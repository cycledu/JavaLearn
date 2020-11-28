package java8.MultypleThread.Charper3.test2.exthread;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:53
 * @Description :
 * @Page or WebSite：P194
 * @Expected result ：
 */
public class MyThread2 extends Thread {
    private Object lock;
    public MyThread2(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始notify time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束notify time=" + System.currentTimeMillis());
        }
    }
}
