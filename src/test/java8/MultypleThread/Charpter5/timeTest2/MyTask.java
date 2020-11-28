package java8.MultypleThread.Charpter5.timeTest2;

import java.util.TimerTask;

/**
 * @Author : jingtao
 * @Data : 2020/05/07/11:54
 * @Description :
 * @Page or WebSite：P363
 * @Expected result ：
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("任务执行了，时间为："+System.currentTimeMillis());
    }
}
