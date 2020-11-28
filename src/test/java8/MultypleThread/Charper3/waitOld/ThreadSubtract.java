package java8.MultypleThread.Charper3.waitOld;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/8:53
 * @Description :
 * @Page or WebSite：P222
 * @Expected result ：
 */
public class ThreadSubtract extends Thread {
    private Subtract r;
    public ThreadSubtract(Subtract r) {
        this.r = r;
    }
    @Override
    public void run() {
        r.subtract();
    }
}
