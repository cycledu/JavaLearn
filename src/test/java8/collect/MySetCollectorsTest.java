package java8.collect;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/07/27/20:49
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class MySetCollectorsTest {
    @Test
    public void test() {
        List<String> list = Arrays.asList("hello", "world", "welcome");
        list.stream().collect(new MySetCollect<>());
        System.out.println(list);
    }
}
