package java8.concurrent;

import java.util.Date;

/**
 * @Author : jingtao
 * @Data : 2020/09/03/22:12
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class SynTest {
    private String one;
    private String two;
    private int num = 0;

    public synchronized void changeAll() throws InterruptedException {

        this.one = Thread.currentThread().getName() + ":" + System.currentTimeMillis() + "��" + Integer.toString(++num);
        Thread.sleep(3300);
        this.two = Thread.currentThread().getName() + ":" + System.currentTimeMillis() + "��" + Integer.toString(++num);
    }

    public void changeOne() {
        this.two = Thread.currentThread().getName() + ":" + System.currentTimeMillis() + "��" + Integer.toString(++num);
    }

    @Override
    public String toString() {
        return "SynTest{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                '}';
    }
}
