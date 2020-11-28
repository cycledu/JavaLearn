package java8.MultypleThread.Charper3.p_r_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:08
 * @Description :
 * @Page or WebSite：P226
 * @Expected result ：
 */
public class ThreadP extends Thread{
    private P p;
    public ThreadP(P p) {
        this.p = p;
    }
    @Override
    public void run() {
        while (true)
            p.setValue();
    }
}
