package java8.MultypleThread.Charpet1.section1_2;

/**
 * @Author : jingtao
 * @Data : 2020/04/12/17:24
 * @Description :线程的执行代码
 * @Page or WebSite：P6/1.2.1
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();//耗时大
        //使用继承了Thread类的start方法来启动一个线程，线程启动后会自动调用线程对象中的run()方法，
        //run方法内部就是线程对象要执行的任务
        myThread.start();
//        myThread.start();//若调用多次start方法，会抛出IllegalThreadStateException
        Thread.sleep(300);//若不将main的线程设置等待时间，大概率main方法输出语句的执行要先与myThread类中的输出
        System.out.println("运行结束");//耗时小
    }
}
