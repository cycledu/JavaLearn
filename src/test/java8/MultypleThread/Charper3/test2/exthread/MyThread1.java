package java8.MultypleThread.Charper3.test2.exthread;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:53
 * @Description :
 * @Page or WebSite：P194
 * @Expected result ：
 */
public class MyThread1 extends Thread{
    private Object lock;
    public MyThread1(Object lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("开始wait time="+System.currentTimeMillis());
                lock.wait();
                System.out.println("结束wait time="+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
