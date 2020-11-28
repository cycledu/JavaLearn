package DesignPattern.factory.simplefactory.order;

import DesignPattern.factory.Pizza;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/11:15
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class PizzaStore {
    @Test
    public void factory() throws IOException {
        OrderPizza orderPizza = new OrderPizza();
    }

    @Test
    public void testSimple() {
        new OrderPizza(new SimpleFactory());
        Pizza pizza = SimpleFactory.creaetPizza("cheese");
        pizza.toString();
    }
}
