package java8.MultypleThread.Charper3.wait_notify_service;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/7:51
 * @Description :
 * @Page or WebSite：P200
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) throws InterruptedException{
        MyService myService=new MyService();
        ThreadA t1=new ThreadA(myService);
        t1.start();
        Thread.sleep(5000);
        ThreadB t2=new ThreadB(myService);
        t2.start();
    }
}
