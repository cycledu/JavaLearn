package java8.MultypleThread.Charpet1.section1_2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/19:35
 * @Description :
 * @Page or WebSite：P14/1.2.5
 * @Expected result ：
 */
public class RunRunnableTest {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("运行结束");
    }
}
