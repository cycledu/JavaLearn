package java8.MultypleThread.Charpter4.ConditionTestMoreMethod;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:36
 * @Description :
 * @Page or WebSite：P302
 * @Expected result ：
 */
public class ThreadA extends Thread{
    private MyService service;
    public ThreadA(MyService service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.methodA();
    }
}
