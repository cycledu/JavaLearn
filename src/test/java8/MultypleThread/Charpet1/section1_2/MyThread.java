package java8.MultypleThread.Charpet1.section1_2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/17:21
 * @Description :创建一个线程
 * @Page or WebSite：P6/1.2.1
 * @Expected result ：
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
