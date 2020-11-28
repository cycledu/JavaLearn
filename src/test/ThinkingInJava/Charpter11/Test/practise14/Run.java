package ThinkingInJava.Charpter11.Test.practise14;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/15:19
 * @Description :
 * @Page or WebSite：P229/练习14
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        ListIterator<Integer> integerListIterator = list.listIterator();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }


    }
}
