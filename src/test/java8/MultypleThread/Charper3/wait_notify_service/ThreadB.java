package java8.MultypleThread.Charper3.wait_notify_service;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/7:50
 * @Description :
 * @Page or WebSite：P200
 * @Expected result ：
 */
public class ThreadB extends Thread{
    private MyService myService;
    public ThreadB(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run() {
        myService.notifyMethod();
    }
}
