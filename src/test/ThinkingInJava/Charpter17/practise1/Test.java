package ThinkingInJava.Charpter17.practise1;


import ThinkingInJava.Charpter17.util.Countries;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/05/15/22:28
 * @Description :
 * @Page or WebSite：P470/练习1
 * @Expected result ：
 */
public class Test {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Countries.names(10));
        System.out.println(strings);
        for (int i = 0; i < 5; i++) {
            Collections.shuffle(strings,new Random(5));
            System.out.println(strings);
            System.out.println();
        }
        System.out.println("_______________________________");
        LinkedList<String> strings1 = new LinkedList<>(Countries.names(10));
        System.out.println(strings1);
    }
}
