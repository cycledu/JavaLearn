package java8.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author : jingtao
 * @Data : 2020/10/14/23:45
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class TestRefelect {
    String filed;


    public static void main(String[] args) {
        for (Method method : TestRefelect.class.getDeclaredMethods()) {
            System.out.println(method.getParameterTypes().getClass().getSimpleName());
        }
    }

    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<TestRefelect> testRefelectClass = TestRefelect.class;
//        TestRefelect testRefelect = TestRefelect.class.newInstance();
        Constructor<TestRefelect> constructor = testRefelectClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        TestRefelect testRefelect1 = constructor.newInstance();
    }

    @Test
    public void testInvokeString() throws NoSuchFieldException, IllegalAccessException {
        String a = "123";
        Field value = a.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(a, new char[]{'a', 'b', 'c'});
        System.out.println(a);
    }

}
