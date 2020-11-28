package java8.MultypleThread.Charper3.Stack_50.set;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:43
 * @Description :
 * @Page or WebSite：P245
 * @Expected result ：
 */
public class SetCheckThread extends Thread{
    private SetService setService;
    public SetCheckThread(SetService setService) {
        this.setService = setService;
    }
    @Override
    public void run() {
        setService.checkBoxStatus();
    }
}
