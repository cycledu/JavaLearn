package ThinkingInJava.Charpter11.Test.practise12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/15:10
 * @Description :
 * @Page or WebSite：P228/练习12
 * @Expected result ：
 */
public class Run {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt((Math.random() * 100 + " ").substring(0, 1)));
        }
        System.out.println(list);

        //第一种方法
        List<Integer> list1 = new ArrayList<>(5);
        ListIterator<Integer> integerListIterator = list.listIterator(5);
        while (integerListIterator.hasPrevious()){
            list1.add(integerListIterator.previous());
        }
        System.out.println(list1);

        //第二种方法
        list1.clear();
        for (int i = 0; i < 5; i++) {
            list1.add(list1.size()-i,list.get(i));
        }
        System.out.println(list1);

    }
}
