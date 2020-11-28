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
public class Test2 {
    public static void main(String[] args) throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        System.out.println("begin " + System.currentTimeMillis());
        System.currentTimeMillis();
        //如果传入true，则第2个参数时间单位为毫秒
        unsafe.park(true, System.currentTimeMillis() + 3000);
        System.out.println("end " + System.currentTimeMillis());
    }
}
