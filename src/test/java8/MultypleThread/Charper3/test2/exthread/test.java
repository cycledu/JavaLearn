package java8.MultypleThread.Charper3.test2.exthread;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:58
 * @Description :
 * @Page or WebSite：P195
 * @Expected result ：
 */
/**
 * 1.执行线程1的wait方法后在原地等待，并释放锁，并由线程2获得锁并执行方法
 * 2.线程2的notify方法执行后，通知线程1，线程2的方法执行完成后，线程1重新获得锁，并执行他的剩下程序
 *
 * wait和notyfy方法都必须在线程获得对象级别锁时执行（即在同步方法或同步方法块中调用两个方法），否则会抛出IllegalMonitorStateException
 */
public class test {
    public static void main(String[] args) {
        try{
            Object lock=new Object();
            MyThread1 thread1 = new MyThread1(lock);
            thread1.start();
            Thread.sleep(3000);
            MyThread2 thread2=new MyThread2(lock);
            thread2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
