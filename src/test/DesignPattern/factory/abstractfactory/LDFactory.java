package DesignPattern.factory.abstractfactory;

import DesignPattern.factory.Pizza;
import DesignPattern.factory.pizza.LDCheesePizza;
import DesignPattern.factory.pizza.LDPepperPizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/13:18
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class LDFactory implements AbsFactory {

    @Override
    public Pizza createPizza(String orderType) {
        if (orderType.equals("pepper")) {
            return new LDPepperPizza();
        } else if (orderType.equals("cheese")) {
            return new LDCheesePizza();
        }
        return null;
    }
}
