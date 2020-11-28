package java8.MultypleThread.Charper3.Stack_50.set;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:42
 * @Description :
 * @Page or WebSite：P244
 * @Expected result ：
 */
public class SetValueThread extends Thread {
    private SetService setService;
    public SetValueThread(SetService setService) {
        this.setService = setService;
    }
    @Override
    public void run() {
        while (true) {
            setService.setMethod();
        }
    }
}
