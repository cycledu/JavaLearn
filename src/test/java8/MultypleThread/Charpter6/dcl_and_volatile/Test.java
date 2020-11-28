package java8.MultypleThread.Charpter6.dcl_and_volatile;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/14:47
 * @Description :
 * @Page or WebSite：P397
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            CountDownLatch latch = new CountDownLatch(1);
            CountDownLatch end = new CountDownLatch(100);
            for (int i = 0; i < 100; i++) {
                Thread t1 = new Thread() {
                    @Override
                    public void run() {
                        try {
                            latch.wait();
                            OneInstanceService one = OneInstanceService.getTest();
                            if (one.i_am_has_state == 0) {
                                System.out.println("one.i_am_has_state == 0 进程结束");
                                System.exit(0);
                            }
                            end.countDown();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                t1.start();
            }
            latch.countDown();
            end.await();
            OneInstanceService.reset();
        }
    }
}
