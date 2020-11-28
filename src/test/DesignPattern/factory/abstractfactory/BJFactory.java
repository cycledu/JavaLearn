package DesignPattern.factory.abstractfactory;

import DesignPattern.factory.Pizza;
import DesignPattern.factory.pizza.BJCheesePizza;
import DesignPattern.factory.pizza.BJPepperPizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/13:18
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class BJFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        if (orderType.equals("pepper")) {
            return new BJPepperPizza();
        } else if (orderType.equals("cheese")) {
            return new BJCheesePizza();
        }
        return null;
    }
}
