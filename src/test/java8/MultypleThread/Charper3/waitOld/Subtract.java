package java8.MultypleThread.Charper3.waitOld;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/8:48
 * @Description :
 * @Page or WebSite：P221
 * @Expected result ：
 */
public class Subtract {
    private String lock;
    public Subtract(String lock) {
        this.lock = lock;
    }
    public void subtract() {
        try {
            int i = 0;
            synchronized (lock) {
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait en ThreadName=" + Thread.currentThread().getName());
                }
                //两个减操作的线程在前后都判断size为0，并wait，加线程执行并释放锁后，两个减线程都开始执行并随后remove操作，所以会出现异常，
                //解决方法是将if改为while
                ValueObject.list.remove(0);
                System.out.println("list size=" + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
