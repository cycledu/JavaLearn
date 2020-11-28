package java8.MultypleThread.Charper3.joinMoreTest;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/14:13
 * @Description :
 * @Page or WebSite：P268
 * @Expected result ：
 */
public class ThreadA extends Thread {
    private ThreadB b;
    public ThreadA(ThreadB b) {
        this.b = b;
    }
    @Override
    public void run() {
        try {
            synchronized (b) {
                System.out.println("begin A ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("end A ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
