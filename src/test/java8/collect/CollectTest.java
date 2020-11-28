package java8.collect;

import java8.Stream.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @Author : jingtao
 * @Data : 2020/07/25/16:23
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class CollectTest {

    @Test
    public void test1() {
        List<Student> strings = Arrays.asList(new Student("zhangsan", 20, 20), new Student("lisi", 40, 23), new Student("wangwu", 14, 23), new Student("wangwu", 14, 23));
        strings.stream().collect(minBy(Comparator.comparingInt(Student::getAge))).ifPresent(System.out::println);
        System.out.println(strings.stream().collect(averagingInt(Student::getAge)));
        System.out.println(strings.stream().collect(summarizingInt(Student::getAge)));//综合信息
        System.out.println(strings.stream().map(Student::getName).collect(Collectors.joining(",")));
        //分组（根据值分组），groupingBy中可以不断追加groupingBy进行多级分组
        Map<Integer, Map<String, List<Student>>> collect = strings.stream().collect(groupingBy(Student::getScore, groupingBy(Student::getName)));
        System.out.println(collect);
        //分区(依据判断分区，分false组和true组)
        System.out.println(strings.stream().collect(partitioningBy(s -> s.getScore() > 21)));
    }

    //Comparator
    @Test
    public void test2() {
        List<String> list = Arrays.asList("R", "A", "B", "F");
        list.sort(String::compareTo);
        System.out.println(list);
        List<String> list1 = Arrays.asList("Ef3", "A3", "B33", "Eee");
        Collections.sort(list1, Comparator.comparingInt(String::length));//升序
        Collections.sort(list1, Comparator.comparingInt(String::length).reversed());//降序
        Collections.sort(list1, Comparator.comparingInt((String i) -> i.length()).reversed());//必须显示声明参数类型
        Collections.sort(list1,Comparator.comparingInt(String::length).thenComparing(String::compareTo));//多级比较（外层和内层）
        Collections.sort(list1,Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        Collections.sort(list1,
                Comparator.comparingInt(String::length).thenComparing((String a,String b)->b.compareTo(a)));
        System.out.println(list1);
    }
}