package java8.concurrent;

/**
 * @Author : jingtao
 * @Data : 2020/09/03/22:15
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        SynTest synTest = new SynTest();
        TestThreadA threadA = new TestThreadA("ThreadA", synTest);
        threadA.start();
        Thread.sleep(2000);
        //在某线程在同步方法中修改实例变量时另一处非同步方法也修改实例变量，同步关键字失去了它的意义，并没有发挥出它同步的访问实例变量功能，然后维持线程安全的效果
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
