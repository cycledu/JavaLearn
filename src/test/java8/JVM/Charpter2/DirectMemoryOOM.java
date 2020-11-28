package java8.JVM.Charpter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/16:30
 * @Description : -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Page or WebSite：2-10
 * @Expected result ：
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError
 * at sun.misc.Unsafe.allocateMemory(Native Method)
 * at Charpter2.DirectMemoryOOM.main(DirectMemoryOOM.java:21)
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
