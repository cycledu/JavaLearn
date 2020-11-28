package java8.MultypleThread.Charpter4.ReentrantLockTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:57
 * @Description :
 * @Page or WebSite：P310
 * @Expected result ：
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin " + System.currentTimeMillis());
        System.currentTimeMillis();
        //3秒的纳秒值为3000 000 000
        //3秒的微秒值为3000 000
        //3秒的毫秒值为3000
        unsafe.park(false, 3000000000L);
        System.out.println("end " + System.currentTimeMillis());
    }
}
