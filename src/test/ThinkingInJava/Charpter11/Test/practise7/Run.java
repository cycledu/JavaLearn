package ThinkingInJava.Charpter11.Test.practise7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/14:42
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        List<AClass>list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new AClass(i));
        }
        System.out.println(list);
        List<AClass> SubList =list.subList(3,7);
        System.out.println(SubList);
        list.removeAll(SubList);
        System.out.println(list);
    }
}
