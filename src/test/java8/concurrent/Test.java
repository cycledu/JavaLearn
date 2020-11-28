package java8.concurrent;

/**
 * @Author : jingtao
 * @Data : 2020/09/03/22:15
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();
        TestThreadA threadA = new TestThreadA("ThreadA", synTest);
        threadA.start();
        Thread.sleep(2000);
        //��ĳ�߳���ͬ���������޸�ʵ������ʱ��һ����ͬ������Ҳ�޸�ʵ��������ͬ���ؼ���ʧȥ���������壬��û�з��ӳ���ͬ���ķ���ʵ���������ܣ�Ȼ��ά���̰߳�ȫ��Ч��
        synTest.changeOne();
        while (threadA.isAlive()) {
            System.out.println(synTest);
        }
    }
}

class TestThreadA extends Thread {
    public TestThreadA(String name, SynTest synTest) {
        super(name);
        this.synTest = synTest;
    }

    SynTest synTest;

    @Override
    public void run() {
        try {
            synTest.changeAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
