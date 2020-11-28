package java8.MultypleThread.Charper3.Stack_50.get;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:49
 * @Description :
 * @Page or WebSite：P246
 * @Expected result ：
 */
public class GetValueThread extends Thread{
    private GetService getService;
    public GetValueThread(GetService getService) {
        this.getService = getService;
    }
    @Override
    public void run() {
        while (true){
            getService.getMethod();
        }
    }
}
