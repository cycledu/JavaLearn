package java8.lambda;

import org.junit.Test;

/**
 * @Author : jingtao
 * @Data : 2020/06/29/20:34
 * @Description :
 * @Page or WebSite：
 * @Expected result ：
 */
@FunctionalInterface
interface MyInterfaceQ {
    void test();

    String toString();
}
public class MyInterface {
    public void mTest(MyInterfaceQ myInterfaceQ) {
        System.out.println(1);
        myInterfaceQ.test();
        System.out.println(2);
    }
    @Test
    public void A( ) {
        MyInterface myInterface = new MyInterface();
        myInterface.mTest(new MyInterfaceQ() {
            @Override
            public void test() {
                System.out.println("接口中实现的方法");
            }
        });
    }

    @Test
    public void B() {
        MyInterface myInterface = new MyInterface();
        myInterface.mTest(() -> System.out.println("lambda"));
    }
    //  () -> System.out.println("lambda")  相当与MyInterfaceQ的一个实现
}