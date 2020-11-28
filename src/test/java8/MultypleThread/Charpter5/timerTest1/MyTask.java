package java8.MultypleThread.Charpter5.timerTest1;

import java.util.TimerTask;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/10:54
 * @Description :
 * @Page or WebSite：P356
 * @Expected result ：
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为："+System.currentTimeMillis());
    }
}
