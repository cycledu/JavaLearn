package java8.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/11/25/22:20
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class TestArrayAndList {

    @Test
    public void testArraytoList() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        // System.out.println(integers.add(2));//java.lang.UnsupportedOperationException因为此时的list的Arrays
        // 的一个内部类，继承于AbstractList，未实现很多方法；
        List<Integer> list = new ArrayList<>(integers);
        list.add(2);
        list.forEach(System.out::println);
        Arrays.stream(integers.toArray()).forEach(System.out::println);
    }

    @Test
    public void testListToArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Object[] objects = list.toArray();
        objects[1] = 3;
        Arrays.stream(objects).forEach(System.out::println);
    }
}
