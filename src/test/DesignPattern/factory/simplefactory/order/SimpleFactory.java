package DesignPattern.factory.simplefactory.order;

import DesignPattern.factory.simplefactory.Pizza.CheesePizza;
import DesignPattern.factory.simplefactory.Pizza.GreekPizza;
import DesignPattern.factory.simplefactory.Pizza.PepperPizza;
import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/11:49
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */


public class SimpleFactory {
    /**
     * �򵥹���ģʽ����һ�������������������һ�ֲ�Ʒ���ʵ��
     */
    public static Pizza creaetPizza(String orderType) {
        System.out.println("ʹ�ü򵥹���ģʽ");
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
