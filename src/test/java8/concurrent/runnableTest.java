package java8.concurrent;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/11/24/9:36
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class runnableTest {
    @Test
    public void test() {
        Runnable runnable = () ->
                System.out.println("A");
        new Thread(runnable).start();
    }
}
