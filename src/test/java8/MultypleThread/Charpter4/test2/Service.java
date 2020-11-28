package java8.MultypleThread.Charpter4.test2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/16:51
 * @Description :
 * @Page or WebSite：P326
 * @Expected result ：
 */
public class Service {
    public ReentrantLock lock = new ReentrantLock();
    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "进入方法");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
