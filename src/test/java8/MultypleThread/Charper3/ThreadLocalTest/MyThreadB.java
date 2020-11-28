package java8.MultypleThread.Charper3.ThreadLocalTest;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/14:40
 * @Description :
 * @Page or WebSite：P278
 * @Expected result ：
 */
public class MyThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Tools.t1.set("B" + (i + 1));
                System.out.println("B get " + Tools.t1.get());
                int sleepValue = (int) (Math.random() * 1000);
                Thread.sleep(sleepValue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
