package java8.MultypleThread.Test;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @Author : jingtao
 * @Data : 2020/11/20/9:31
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class StringTest {

    @Test
    public void test() throws IllegalAccessException, NoSuchFieldException {
        String s = "abcd";

        System.out.println("s=" + s);

        Field valueField = String.class.getDeclaredField("value");

        valueField.setAccessible(true);

        char[] value = (char[]) valueField.get(s);

        value[3] = 'e';
        System.out.println("s=" + s);
    }

}
