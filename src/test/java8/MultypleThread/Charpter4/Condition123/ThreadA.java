package java8.MultypleThread.Charpter4.Condition123;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/17:32
 * @Description :
 * @Page or WebSite：P347
 * @Expected result ：
 */
public class ThreadA extends Thread{
    private MyService service;
    public ThreadA(MyService service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod1();
    }
}
