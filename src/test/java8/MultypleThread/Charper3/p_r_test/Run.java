package java8.MultypleThread.Charper3.p_r_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:11
 * @Description :
 * @Page or WebSite：P226
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();
    }
}
