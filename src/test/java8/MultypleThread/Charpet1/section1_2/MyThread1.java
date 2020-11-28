package java8.MultypleThread.Charpet1.section1_2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/19:13
 * @Description :
 * @Page or WebSite：P11/1.2.3
 * @Expected result ：
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("run="+Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("myThread");
        myThread1.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("main= "+Thread.currentThread().getName());
        }
    }
}
