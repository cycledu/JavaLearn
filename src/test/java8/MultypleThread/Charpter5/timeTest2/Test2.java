package java8.MultypleThread.Charpter5.timeTest2;

import java.util.Date;
import java.util.Timer;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/11:58
 * @Description :
 * @Page or WebSite：P363
 * @Expected result ：
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException{
        long nowTime = System.currentTimeMillis();
        System.out.println("当前时间为："+nowTime);
        long scheduleTime1 = nowTime + 5000;
        long scheduleTime2 = nowTime + 8000;
        System.out.println("计划时间1为："+scheduleTime1);
        System.out.println("计划时间2为："+scheduleTime2);
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task1,new Date(scheduleTime1));
        timer.schedule(task2,new Date(scheduleTime2));
    }
}
