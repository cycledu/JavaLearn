package java8.MultypleThread.Charpter6.singleton_5;


/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:14
 * @Description :
 * @Page or WebSite：P392
 * @Expected result ：
 */

//在多线程的情况下，只同步创建对象的代码，并没有实现单例的效果
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
