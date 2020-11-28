package java8.MultypleThread.Charper3.p_r_test;

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
                if (ValueObject.value.equals(""))
                    lock.wait();
                System.out.println("get的值是"+ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
