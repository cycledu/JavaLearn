package java8.MultypleThread.Charper3.TwoThreadTransData.mylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/04/30/22:30
 * @Description :
 * @Page or WebSite：P189
 * @Expected result ：
 */
public class MyList {
    volatile private List list=new ArrayList();
    public void add(){
        list.add("高洪岩");
    }
    public int size(){
        return list.size();
    }
}
