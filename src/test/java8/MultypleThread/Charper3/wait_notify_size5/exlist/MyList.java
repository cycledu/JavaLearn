package java8.MultypleThread.Charper3.wait_notify_size5.exlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/23:16
 * @Description :
 * @Page or WebSite：P196
 * @Expected result ：
 */
public class MyList {
    private static List list=new ArrayList();
    public static void add(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}
