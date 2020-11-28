package java8.MultypleThread.Charper3.Stack_50.get;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:50
 * @Description :
 * @Page or WebSite：P246
 * @Expected result ：
 */
public class GetCheckThread extends Thread{
    private GetService service;
    public GetCheckThread(GetService service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.checkBoxStatus();
    }
}
