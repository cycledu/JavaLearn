package java8.MultypleThread.Charper3.joinMoreTest;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/14:17
 * @Description :
 * @Page or WebSite：P269
 * @Expected result ：
 */
public class Run1 {
    public static void main(String[] args) {
        try {
            ThreadB threadB = new ThreadB();
            ThreadA threadA = new ThreadA(threadB);
            threadA.start();
            threadB.start();
            threadB.join(200);
            System.out.println("    main end " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
