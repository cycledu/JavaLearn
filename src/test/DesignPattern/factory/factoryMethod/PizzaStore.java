package DesignPattern.factory.factoryMethod;

import DesignPattern.factory.factoryMethod.order.BJOrderPizza;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:26
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class PizzaStore {
    @Test
    public void test() throws IOException {

        /**
         * 创建北京披萨,会要求调用父类构造方法，然后会回调子类实现的抽象方法
         */
        BJOrderPizza bjOrderPizza = new BJOrderPizza();

    }
}
