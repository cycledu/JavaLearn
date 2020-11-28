package java8.Stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author : jingtao
 * @Data : 2020/07/04/10:37
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class testStream {

    //创建stream的方式
    @Test
    public void test() {
        Stream<String> stream = Stream.of("A", "B", "C");
        String[] array = new String[]{"C", "D", "E"};
        Stream<String> stream1 = Stream.of(array);
        Stream<String> stream2 = Arrays.stream(array);

        List<String> strings = Arrays.asList(array);
        Stream<String> stream3 = strings.stream();
    }

    @Test
    public void test1() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        System.out.println("===============");
        IntStream.range(2, 7).forEach(System.out::println);
        System.out.println("===========");
        IntStream.rangeClosed(2, 7).forEach(System.out::println);
    }

    @Test
    public void test2() {
        //集合元素乘2在求和
        System.out.println(IntStream.of(new int[]{2, 6, 8}).map(i -> i * 2).sum());
        System.out.println(Arrays.asList(2, 6, 8).stream().map(i -> i * 2).reduce(0, Integer::sum));
    }

    @Test
    public void test3() {
        //流转换为数组
        Stream<String> stream = Stream.of("hello", "hello", "helloworld");
//        String[] strings = stream.toArray(ele -> new String[ele]);
        // String[] strings = stream.toArray(String[]::new);
        //   Arrays.asList(strings).forEach(System.out::println);
        //流转换为集合
        //  List<String> collect = stream.collect(Collectors.toList());
//        stream.collect(() -> new HashSet(), (theList, item) -> theList.add(item),
//                (list1, list2) -> list1.addAll(list2)).forEach(System.out::println);
        stream.collect(HashSet::new
                , HashSet::add
                , HashSet::addAll
        ).forEach(System.out::println);
    }

    //元素转换为大写
    @Test
    public void test4() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();
        stream.map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void test5() {
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4), Arrays.asList(7, 5, 8));
        listStream.flatMap(list -> list.stream()).map(item -> item * item).forEach(System.out::println);
    }

    @Test
    public void test6() {
        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);

        generate.findFirst().ifPresent(System.out::println);
    }

    @Test
    public void test7() {
        //找到元素中去掉前两个乘以2，在取前两个求和
        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(i -> i * 2).skip(2).limit(2).sum());
    }

    @Test
    public void test8() {
        List<String> list = Arrays.asList("asdsd", "bsdas", "cdsad");
        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).forEach(System.out::println);
    }

    @Test
    public void test9() {
        List<String> list = Arrays.asList("fdsfsd", "hello", "world");
        list.stream().filter(v -> v.length() == 5).limit(1).forEach(v -> {
            System.out.println(v);
            System.out.println(5);
        });
        System.out.println("=======================");
        List<String> list2 = Arrays.asList("fdsfsd", "hello", "world");
        list.stream().mapToInt(String::length).filter(v -> v == 5).findFirst().ifPresent(System.out::println);
    }

    //元素分割去重
    /**
     * fds
     * fsd
     * he
     * llo
     * worl
     * d
     */
    @Test
    public void tesrr10() {
        List<String> list = Arrays.asList("fds fsd", "he llo", "worl d", "he llo", "fds fsd", "worl d");
        list.stream().map(i -> i.split(" ")).flatMap(Stream::of).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
