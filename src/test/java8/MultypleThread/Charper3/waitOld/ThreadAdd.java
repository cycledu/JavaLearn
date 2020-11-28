package java8.MultypleThread.Charper3.waitOld;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/8:53
 * @Description :
 * @Page or WebSite：P222
 * @Expected result ：
 */
public class ThreadAdd extends Thread{
    private Add p;
    public ThreadAdd(Add p){
        this.p=p;
    }
    @Override
    public void run() {
        p.add();
    }
}
