package java8.MultypleThread.Charpter7;

/**
 * @Author : jingtao
 * @Data : 2020/09/22/21:19
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class ThreadLocalTest extends Thread {
    private  static  InheritableThreadLocal threadLocal = new InheritableThreadLocal();
    public ThreadLocalTest(String a) {
        super(a);
    }

    @Override
    public void run() {
        System.out.println(threadLocal.get());
        System.out.println(Thread.currentThread().getThreadGroup().getParent());
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        threadLocal.set("AA");
        Thread a = new ThreadLocalTest("A");
        a.start();
    }
}
