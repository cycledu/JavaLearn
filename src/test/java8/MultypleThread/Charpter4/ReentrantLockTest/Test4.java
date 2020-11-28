package java8.MultypleThread.Charpter4.ReentrantLockTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:57
 * @Description :
 * @Page or WebSite：P311
 * @Expected result ：
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin " + System.currentTimeMillis());
        System.currentTimeMillis();
        unsafe.park(true, 0L);
        System.out.println("end " + System.currentTimeMillis());
    }
}
