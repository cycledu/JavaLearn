package java8.MultypleThread.Charpter4.UseConditionWaitNotifyError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:44
 * @Description :
 * @Page or WebSite：P304
 * @Expected result ：
 */
public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await() {
        try {
            condition.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
