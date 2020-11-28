package java8.MultypleThread.Charper3.p_r_allWait;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:11
 * @Description :
 * @Page or WebSite：P226
 * @Expected result ：
 */
//多消费者多生产者，在都唤醒同类的情况下，对全部进入阻塞状态，最简单的解决方法就是将notify方法的调用改成notifyAll
public class Run {
    public static void main(String[] args) throws InterruptedException{
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP[] threadP = new ThreadP[2];
        ThreadC[] threadC = new ThreadC[2];
        for (int i = 0; i < 2; i++) {
            threadP[i]= new ThreadP(p);
            threadP[i].setName("生产者"+(i+1));
            threadC[i]=new ThreadC(c);
            threadC[i].setName("消费者"+(i+1));
            threadP[i].start();
            threadC[i].start();
        }
        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());
        }
    }
}
