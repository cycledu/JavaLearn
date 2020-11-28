package java8.concurrent;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/11/24/9:36
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class runnableTest {
    @Test
    public void test() {
        Runnable runnable = () ->
                System.out.println("A");
        new Thread(runnable).start();
    }
}
