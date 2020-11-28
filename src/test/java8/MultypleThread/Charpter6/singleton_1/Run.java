package java8.MultypleThread.Charpter6.singleton_1;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/13:14
 * @Description :
 * @Page or WebSite：P386
 * @Expected result ：
 */

//运行输出同一散列值，说明为同一个对象，但在多线程环境中会出现多个实例的情况
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
