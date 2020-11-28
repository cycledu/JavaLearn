package java8.MultypleThread.Charper3.Stack_50.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/05/03/12:32
 * @Description :
 * @Page or WebSite：P243
 * @Expected result ：
 */
public class Box {
    private static List list = new ArrayList();
    synchronized public void add() {
        if (size() < 50) {
            list.add("anyString");
            System.out.println("线程：" + Thread.currentThread().getName() + "执行add()方法，size大小为：" + size());
        }
    }
    synchronized public int size() {
        return list.size();
    }
    synchronized public Object popFirst() {
        Object value = list.remove(0);
        System.out.println("线程：" + Thread.currentThread().getName() + "执行popFirst()方法，size大小为：" + size());
        return value;
    }
}
