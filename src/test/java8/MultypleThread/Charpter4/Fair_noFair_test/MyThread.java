package java8.MultypleThread.Charpter4.Fair_noFair_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/16:34
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class MyThread extends Thread{
    private MyService service;
    public MyThread(MyService service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.testMethod();
    }
}
