package java8.MultypleThread.Test;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author : jingtao
 * @Data : 2020/11/12/15:42
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class CyclicBarrierDemo {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " ����դ�� A");
                barrier.await();//�̵߳�������ȴ�
                System.out.println(getName() + " ����դ�� A");

                Thread.sleep(2000);
                System.out.println(getName() + " ����դ�� B");
                barrier.await();
                System.out.println(getName() + " ����դ�� B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum, () ->
                System.out.println(Thread.currentThread().getName() + " ����������")
        );

        for (int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }

}
