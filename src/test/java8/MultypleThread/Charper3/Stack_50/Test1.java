package java8.MultypleThread.Charper3.Stack_50;


import java8.MultypleThread.Charper3.Stack_50.get.GetCheckThread;
import java8.MultypleThread.Charper3.Stack_50.get.GetService;
import java8.MultypleThread.Charper3.Stack_50.get.GetValueThread;
import java8.MultypleThread.Charper3.Stack_50.set.SetCheckThread;
import java8.MultypleThread.Charper3.Stack_50.set.SetService;
import java8.MultypleThread.Charper3.Stack_50.set.SetValueThread;
import java8.MultypleThread.Charper3.Stack_50.tools.Box;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:51
 * @Description :
 * @Page or WebSite：P247
 * @Expected result ：
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        SetService setService = new SetService(box);
        for (int i = 0; i < 2; i++) {
            SetValueThread setValueThread1 = new SetValueThread(setService);
            setValueThread1.start();
        }
        Thread.sleep(50);
        SetCheckThread setCheckThread = new SetCheckThread(setService);
        setCheckThread.start();

        Thread.sleep(10000);
        GetService getService = new GetService(box);
        for (int i = 0; i < 10; i++) {
            GetValueThread getValueThread1 = new GetValueThread(getService);
            getValueThread1.start();
        }
        Thread.sleep(50);
        GetCheckThread getCheckThread = new GetCheckThread(getService);
        getCheckThread.start();
    }
}
