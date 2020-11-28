package java8.MultypleThread.Charpter5.timeTest2;

import java.util.Timer;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/11:55
 * @Description :
 * @Page or WebSite：P363
 * @Expected result ：
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        long nowTime = System.currentTimeMillis();
        System.out.println("当前时间为：" + nowTime);
        long scheduleTime = nowTime - 5000;
        System.out.println("计划时间为：" + scheduleTime);

        MyTask task = new MyTask();
        Timer timer = new Timer();
        timer.schedule(task, scheduleTime);

    }
}
