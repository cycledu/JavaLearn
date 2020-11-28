package java8.MultypleThread.Charper3.p_r_allWait;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:03
 * @Description :
 * @Page or WebSite：P224
 * @Expected result ：
 */
public class P {
    private String lock;
    public P(String lock) {
        this.lock = lock;
    }
    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者" + Thread.currentThread().getName() + "WAITING了⭐");
                    lock.wait();
                }
                System.out.println("生产者" + Thread.currentThread().getName() + "RUNNABLE了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
