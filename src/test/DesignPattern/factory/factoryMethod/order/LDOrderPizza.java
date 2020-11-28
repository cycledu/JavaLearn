package DesignPattern.factory.factoryMethod.order;

import DesignPattern.factory.Pizza;
import DesignPattern.factory.pizza.LDCheesePizza;
import DesignPattern.factory.pizza.LDPepperPizza;

import java.io.IOException;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:22
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class LDOrderPizza extends OrderPizza {
    /**
     * ����һ�����󷽷����ø������������Լ�ʵ��
     */
    public LDOrderPizza() throws IOException {
    }

    @Override
    Pizza createPizza(String orderType) {
        if (orderType.equals("pepper")) {
            return new LDPepperPizza();
        } else if (orderType.equals("cheese")) {
            return new LDCheesePizza();
        }
        return null;
    }
}
