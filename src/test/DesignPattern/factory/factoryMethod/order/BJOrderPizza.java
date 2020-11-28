package DesignPattern.factory.factoryMethod.order;

import DesignPattern.factory.Pizza;
import DesignPattern.factory.pizza.BJCheesePizza;
import DesignPattern.factory.pizza.BJPepperPizza;

import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:22
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class BJOrderPizza extends OrderPizza {

    public BJOrderPizza() throws IOException {
    }
    /**
     * 定义一个抽象方法，让各个工厂子类自己实现
     */
    @Override
    Pizza createPizza(String orderType) {
        if (orderType.equals("pepper")) {
            return new BJPepperPizza();
        } else if (orderType.equals("cheese")) {
            return new BJCheesePizza();
        }
        return null;
    }
}
