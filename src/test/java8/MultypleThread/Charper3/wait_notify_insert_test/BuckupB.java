package java8.MultypleThread.Charper3.wait_notify_insert_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/13:51
 * @Description :
 * @Page or WebSite：P257
 * @Expected result ：
 */
public class BuckupB extends Thread{
    private DBTools dbTools;
    public BuckupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }
    @Override
    public void run() {
        dbTools.buckupB();
    }
}
