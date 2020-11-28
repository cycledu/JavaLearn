package java8.MultypleThread.Charpter4.Fair_noFair_test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/16:31
 * @Description :
 * @Page or WebSite：P322
 * @Expected result ：
 */
public class MyService {
    public Lock lock;
    public MyService(boolean fair) {
        this.lock = new ReentrantLock(true);
    }
    public void testMethod() {
        try {
            lock.lock();
            System.out.println("testMethod " + Thread.currentThread().getName());
            Thread.sleep(500);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
