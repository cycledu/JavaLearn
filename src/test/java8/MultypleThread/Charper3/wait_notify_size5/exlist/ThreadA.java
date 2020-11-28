package java8.MultypleThread.Charper3.wait_notify_size5.exlist;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/23:18
 * @Description :
 * @Page or WebSite：P196
 * @Expected result ：
 */
public class ThreadA extends Thread{
    private Object lock;
    public ThreadA(Object lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        try{
            synchronized (lock){
                if (MyList.size()!=5){
                    System.out.println("wait begin"+System.currentTimeMillis());
                    //由该线程首先获得锁并等待
                    lock.wait();
                    System.out.println("wait end"+System.currentTimeMillis());
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
