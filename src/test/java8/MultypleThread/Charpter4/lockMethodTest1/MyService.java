package java8.MultypleThread.Charpter4.lockMethodTest1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/16:44
 * @Description :
 * @Page or WebSite：P324
 * @Expected result ：
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock(true);
    public void testMethod1() {
        System.out.println("A " + lock.getHoldCount());
        lock.lock();
        System.out.println("B " + lock.getHoldCount());
        testMethod2();
        System.out.println("F " + lock.getHoldCount());
        lock.unlock();
        System.out.println("G " + lock.getHoldCount());

    }
    public void testMethod2() {
        System.out.println("C " + lock.getHoldCount());
        lock.lock();
        System.out.println("D " + lock.getHoldCount());
        lock.unlock();
        System.out.println("E " + lock.getHoldCount());
    }
}
