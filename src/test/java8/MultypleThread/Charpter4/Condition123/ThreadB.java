package java8.MultypleThread.Charpter4.Condition123;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/17:32
 * @Description :
 * @Page or WebSite：P347
 * @Expected result ：
 */
public class ThreadB extends Thread {
    private MyService service;
    public ThreadB(MyService service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod2();
    }
}
