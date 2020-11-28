package java8.MultypleThread.Charpter4.ReentrantLockTest;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:28
 * @Description :
 * @Page or WebSite：P300
 * @Expected result ：
 */
public class MyThread extends Thread{
    private MyService myService;
    public MyThread(MyService myService) {
        this.myService = myService;
    }
    @Override
    public void run() {
        myService.testMethod();
    }
}
