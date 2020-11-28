package java8.lambda;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;

/**
 * @Author : jingtao
 * @Data : 2020/06/29/20:17
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
public class TestLambda {
    @Test
    public void test() {
        List<String> strings = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        strings.forEach(s -> System.out.println(s));
        //method reference
        strings.forEach(System.out::println);
        Function<String, String> doubleToIntFunction = value -> value.toString();
        System.out.println();
    }

    @Test
    public void testFnctional() {
        System.out.println(compute(2, value -> value + value, value -> value * value));
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        System.out.println(function1.apply(2));
        return function1.compose(function2).apply(a);
    }
}
