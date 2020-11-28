package java8.MultypleThread.Charpter4.ReentrantLockTest;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:28
 * @Description :
 * @Page or WebSite：P300
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread myThread = new MyThread(myService);
        MyThread myThread1 = new MyThread(myService);
        MyThread myThread2 = new MyThread(myService);
        MyThread myThread3 = new MyThread(myService);
        MyThread myThread4 = new MyThread(myService);
        myThread.start();
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
    }
}
