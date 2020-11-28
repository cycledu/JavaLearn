package java8.MultypleThread.Charpter6.dcl_and_volatile;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : jingtao
 * @Data : 2020/11/09/19:14
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class CountDownLunchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int a = i;
            new Thread() {
                @Override
                public void run() {
                    System.out.println("----------" + a);
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();//等待21行countDownLatch.countDown()减到零，才会返回执行下面的代码
        System.out.println("结束啦");
    }
}
