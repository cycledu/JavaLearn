package java8.MultypleThread.Charpter4.UseConditionWaitNotifyError;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:46
 * @Description :
 * @Page or WebSite：P305
 * @Expected result ：
 */
public class ThreadA extends Thread{
    private MyService service;
    public ThreadA(MyService service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.await();
    }
}
