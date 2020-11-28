package java8.MultypleThread.Charper3.wait_notify_insert_test;

/**
 * @Author : jingtao
 * @Data : 2020/05/04/13:52
 * @Description :
 * @Page or WebSite：P258
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BuckupA buckupA = new BuckupA(dbTools);
            buckupA.start();
            BuckupB buckupB = new BuckupB(dbTools);
            buckupB.start();
        }
    }
}
