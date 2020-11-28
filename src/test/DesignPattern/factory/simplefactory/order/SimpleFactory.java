package DesignPattern.factory.simplefactory.order;

import DesignPattern.factory.simplefactory.Pizza.CheesePizza;
import DesignPattern.factory.simplefactory.Pizza.GreekPizza;
import DesignPattern.factory.simplefactory.Pizza.PepperPizza;
import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/11:49
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */


public class SimpleFactory {
    /**
     * 简单工厂模式：由一个工厂对象决定创建哪一种产品类的实例
     */
    public static Pizza creaetPizza(String orderType) {
        System.out.println("使用简单工厂模式");
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
        }
        return pizza;
    }
}
