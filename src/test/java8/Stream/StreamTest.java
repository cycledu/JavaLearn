package java8.Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author : jingtao
 * @Data : 2020/07/08/20:04
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class StreamTest {
    @Test
    public void test() {
        List<String> strings = Arrays.asList("Hi", "Hello", "你好");
        List<String> strings1 = Arrays.asList("zhangsan", "lisi", "wangwu");
        strings.stream().flatMap(ite -> strings1.stream().map(it -> ite + " " + it)).collect(Collectors.toList()).forEach(System.out::println);
    }

    //分组
    @Test
    public void test1() {
        List<Student> strings = Arrays.asList(
                new Student("zhangsan", 20, 20),
                new Student("lisi", 40, 34),
                new Student("wangwu", 14, 23),
                new Student("wangwu", 14, 23)
        );
        System.out.println(strings.stream().collect(Collectors.groupingBy(Student::getName)));
        //相当于select count(*) from XXX
        Map<String, Long> collect = strings.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(collect);
    }

    @Test
    public void test2(){
        List<Student> strings = Arrays.asList(
                new Student("zhangsan", 20, 70),
                new Student("lisi", 40, 80),
                new Student("wangwu", 14, 90),
                new Student("wangwu", 14, 111)
        );
    }
}
