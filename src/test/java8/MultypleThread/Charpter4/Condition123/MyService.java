package java8.MultypleThread.Charpter4.Condition123;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/17:25
 * @Description :
 * @Page or WebSite：P346
 * @Expected result ：
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    volatile private int nextWhoPoint = 1;
    public void testMethod1() {
        try {
            lock.lock();
            while (nextWhoPoint != 1) {
                condition.await();
            }
            System.out.println("AAA");
            nextWhoPoint = 2;
            condition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void testMethod2(){
        try {
            lock.lock();
            while (nextWhoPoint != 2) {
                condition.await();
            }
            System.out.println("BBB");
            nextWhoPoint = 3;
            condition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void testMethod3(){
        try {
            lock.lock();
            while (nextWhoPoint != 3) {
                condition.await();
            }
            System.out.println("CCC");
            nextWhoPoint = 1;
            condition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
