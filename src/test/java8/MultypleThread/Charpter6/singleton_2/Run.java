package java8.MultypleThread.Charpter6.singleton_2;


/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:14
 * @Description :
 * @Page or WebSite：P386
 * @Expected result ：
 */

//运行输出3个散列值，不是正确的单例模式
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
