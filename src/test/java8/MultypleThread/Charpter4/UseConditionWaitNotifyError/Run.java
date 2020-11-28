package java8.MultypleThread.Charpter4.UseConditionWaitNotifyError;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:47
 * @Description :
 * @Page or WebSite：P305
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();
    }
}
