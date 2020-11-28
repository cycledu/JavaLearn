package java8.MultypleThread.Charpter5.timerTest1;

import java.util.Date;
import java.util.Timer;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/11:28
 * @Description :
 * @Page or WebSite：P361
 * @Expected result ：
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        long nowTime = System.currentTimeMillis();
        System.out.println("当前时间为：" + nowTime);
        long scheduleTime = nowTime + 15000;
        System.out.println("计划时间为：" + scheduleTime);
        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, new Date(scheduleTime));
        Thread.sleep(18000);
        timer.cancel();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
