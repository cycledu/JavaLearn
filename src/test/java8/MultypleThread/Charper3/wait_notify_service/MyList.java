package java8.MultypleThread.Charper3.wait_notify_service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/05/01/7:42
 * @Description :
 * @Page or WebSite：P198
 * @Expected result ：
 */
public class MyList {
    volatile private List list = new ArrayList();
    public void add() {
        list.add("anyString");
    }
    public int size() {
        return list.size();
    }
}
