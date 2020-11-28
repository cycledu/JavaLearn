package java8.MultypleThread.Charper3.p_r_allWait;

/**
 * @Author : jingtao
 * @Data : 2020/05/02/21:03
 * @Description :
 * @Page or WebSite：P224
 * @Expected result ：
 */
public class C {
    private String lock;
    public C(String lock) {
        this.lock = lock;
    }
    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者" + Thread.currentThread().getName() + "WAITING⭐");
                    lock.wait();
                }
                System.out.println("消费者" + Thread.currentThread().getName() + "RUNNABLE了");
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
