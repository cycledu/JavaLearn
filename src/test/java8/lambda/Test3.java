package java8.lambda;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/06/29/22:12
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
@FunctionalInterface
interface MyInterface3 {
    void myMethod();
}
@FunctionalInterface
interface MyInterface3_1 {
    void myMethod();
}

public class Test3 {
    @Test
    public void test() {
        MyInterface3 myInterface3 = () -> {
        };
        MyInterface3_1 myInterface3_1 = () -> {
        };
        System.out.println(myInterface3.getClass().getInterfaces()[0]);
        System.out.println(myInterface3_1.getClass());
    }
}
