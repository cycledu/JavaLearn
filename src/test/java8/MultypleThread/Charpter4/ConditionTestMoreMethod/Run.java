package java8.MultypleThread.Charpter4.ConditionTestMoreMethod;

/**
 * @Author : jingtao
 * @Data : 2020/05/05/14:38
 * @Description :
 * @Page or WebSite：P303
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.setName("A");
        threadA.start();
        ThreadAA threadAA = new ThreadAA(myService);
        threadAA.setName("AA");
        threadAA.start();
        Thread.sleep(100);
        ThreadB threadB = new ThreadB(myService);
        threadB.setName("B");
        threadB.start();
        ThreadBB threadBB = new ThreadBB(myService);
        threadBB.setName("BB");
        threadBB.start();
    }
}
