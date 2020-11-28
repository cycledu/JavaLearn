package java8.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Author : jingtao
 * @Data : 2020/11/22/14:39
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class deadLock {
    static Object A = new Object();
    static Object B = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (A) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("take A want get B");
                synchronized (B) {
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("take B want get A");
                }
            }
        }).start();

    }
}
