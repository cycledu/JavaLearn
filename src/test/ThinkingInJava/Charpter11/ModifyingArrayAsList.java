package ThinkingInJava.Charpter11;

import java.util.*;

/**
 * @Author : jingtao
 * @Data : 2020/03/31/23:48
 * @Description :
 * @Page or WebSite：244
 * @Expected result ：
 */
public class ModifyingArrayAsList {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list1 = new ArrayList<>(Arrays.asList(ia));
        System.out.println("before suffling " + list1);
        Collections.shuffle(list1);
        System.out.println("after suffling " + list1);
        System.out.println("array " + Arrays.toString(ia));
        System.out.println("list1 hashcode "+list1.hashCode());
        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("ia hashcode "+ia.hashCode());
        System.out.println("before suffling " + list2);
        Collections.shuffle(list2);
        System.out.println("after suffling " + list2);
        System.out.println("array " + Arrays.toString(ia));
        System.out.println("ia hashcode "+ia.hashCode());
        System.out.println("list2 hashcode "+list2.hashCode());

    }
}
