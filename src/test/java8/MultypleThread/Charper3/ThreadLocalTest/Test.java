package java8.MultypleThread.Charper3.ThreadLocalTest;

import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/14:44
 * @Description :
 * @Page or WebSite：P279
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        MyThreadA myThreadA = new MyThreadA();
        MyThreadB myThreadB = new MyThreadB();
        myThreadA.start();
        myThreadB.start();
        for (int i = 0; i < 10; i++) {
            Tools.t1.set("main " + (i + 1));
            System.out.println("    main get " + Tools.t1.get());
            int sleepValue = (int) (Math.random() * 1000);
            Thread.sleep(sleepValue);
        }
    }
}
