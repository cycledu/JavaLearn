package DesignPattern.factory.factoryMethod.order;

import DesignPattern.factory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:19
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public abstract class OrderPizza {
    /**
     * ����һ�����󷽷����ø������������Լ�ʵ��
     */
    public OrderPizza() throws IOException {
        Pizza pizza = null;
        String orderType = null;
        orderType = getType();
        pizza = createPizza(orderType);
        pizza.toString();
    }

    private String getType() throws IOException {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza ����:");
        String str = strin.readLine();
        return str;
    }

    abstract Pizza createPizza(String orderType);
}
