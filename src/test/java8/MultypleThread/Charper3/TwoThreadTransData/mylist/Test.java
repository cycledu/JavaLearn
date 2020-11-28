package java8.MultypleThread.Charper3.TwoThreadTransData.mylist;


import java8.MultypleThread.Charper3.TwoThreadTransData.extthread.ThreadA;
import java8.MultypleThread.Charper3.TwoThreadTransData.extthread.ThreadB;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:40
 * @Description :
 * @Page or WebSite：P190
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
