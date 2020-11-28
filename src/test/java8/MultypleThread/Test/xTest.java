package java8.MultypleThread.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author : jingtao
 * @Data : 2020/11/23/13:31
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class xTest {
    public List testA() {
        int i = 1;
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        List<Integer> integers = new ArrayList<>();
        try {
            return integers;
        } finally {
            integers.add(1);
        }


    }

    public static void main(String[] args) {
        System.out.println(new xTest().testA().size());
    }
}
