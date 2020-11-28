package ThinkingInJava.Charpter11.Test.practise2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : jingtao
 * @Data : 2020/05/10/14:32
 * @Description :
 * @Page or WebSite：P220/练习2
 * @Expected result ：
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Set<Integer> c = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
            c.add(i);
        }
        for (Integer i : c) {
            System.out.println(i);
        }
    }
}
