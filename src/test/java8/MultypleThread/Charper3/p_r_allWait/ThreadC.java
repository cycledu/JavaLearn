package java8.MultypleThread.Charper3.p_r_allWait;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:08
 * @Description :
 * @Page or WebSite：P226
 * @Expected result ：
 */
public class ThreadC extends Thread{
    private C c;
    public ThreadC(C c) {
        this.c = c;
    }
    @Override
    public void run() {
        while (true)
            c.getValue();
    }
}
