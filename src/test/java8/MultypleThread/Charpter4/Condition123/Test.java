package java8.MultypleThread.Charpter4.Condition123;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/17:33
 * @Description :
 * @Page or WebSite：P348
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        for (int i = 0; i < 5; i++) {
            ThreadA a = new ThreadA(service);
            a.start();
            ThreadB b = new ThreadB(service);
            b.start();
            ThreadC c = new ThreadC(service);
            c.start();
        }
    }
}
