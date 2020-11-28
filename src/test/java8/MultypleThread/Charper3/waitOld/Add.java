package java8.MultypleThread.Charper3.waitOld;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/8:45
 * @Description :
 * @Page or WebSite：p220
 * @Expected result ：
 */
public class Add {
    private String lock;
    public Add(String lock) {
        this.lock = lock;
    }
    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
