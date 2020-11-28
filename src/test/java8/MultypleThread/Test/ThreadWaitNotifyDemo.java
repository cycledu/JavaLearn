package java8.MultypleThread.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : jingtao
 * @Data : 2020/11/12/15:32
 * @Description :
 * ʹ��if�����жϺ�, �������߳�A����wait()����̬, �ͷ���, ����������һ���������߳�B����, Ҳ��������̬.
 * �������������߳�C����, ���������������߳�AB, ��ʱ��Դ����Ϊ1.
 * ���ʹ����if, ���������߱����Ѻ�, �߳̽�����ִ���·��Ĵ����, ���½�����-1.
 * @PageOrWebSite��
 * @Expected result ��
 */
class AirConditioner {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        // ʹ��if������ٻ���
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "\t:�������" + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // ʹ��if������ٻ���
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t:�������" + number);
        this.notifyAll();
    }
}

/**
 * �ֱ����������̣߳�ÿ���������ֱ�Թ�������������Ӳ���
 * ��10��
 */
public class ThreadWaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(4);

        AirConditioner airConditioner = new AirConditioner();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    Thread.sleep(200);
                    count.countDown();
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    Thread.sleep(300);
                    count.countDown();
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    Thread.sleep(400);
                    count.countDown();
                    airConditioner.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
//                    Thread.sleep(500);
                    count.countDown();
                    airConditioner.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
        count.await();
    }
}