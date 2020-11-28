package java8.MultypleThread.Charper3.wait_notify_size5.exlist;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/23:18
 * @Description :
 * @Page or WebSite：P197
 * @Expected result ：
 */
public class ThreadB extends Thread{
    private Object lock;
    public ThreadB(Object lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        try{
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    if (MyList.size()==5){
                        //由该线程发出通知
                        lock.notify();
                        System.out.println("已发出通知");
                    }
                    System.out.println("添加了"+(i+1)+"个元素");
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
