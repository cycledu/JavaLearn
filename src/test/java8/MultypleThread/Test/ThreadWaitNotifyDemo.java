package java8.MultypleThread.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : jingtao
 * @Data : 2020/11/12/15:32
 * @Description :
 * 使用if进行判断后, 消费者线程A进入wait()阻塞态, 释放锁, 紧接着有另一个消费者线程B进入, 也进入阻塞态.
 * 紧接着生产者线程C生产, 唤醒两个消费者线程AB, 此时资源数量为1.
 * 如果使用了if, 两个消费者被唤醒后, 线程将继续执行下方的代码块, 导致结果变成-1.
 * @PageOrWebSite：
 * @Expected result ：
 */
class AirConditioner {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        // 使用if出现虚假唤醒
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "\t:将它变成" + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 使用if出现虚假唤醒
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t:将它变成" + number);
        this.notifyAll();
    }
}

/**
 * 分别有两个组线程，每组两个，分别对共享变量进行增加操作
 * 来10轮
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