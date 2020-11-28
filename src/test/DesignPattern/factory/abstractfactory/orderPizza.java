package DesignPattern.factory.abstractfactory;

import DesignPattern.factory.Pizza;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/13:23
 * @Description :
 * @PageOrWebSite£∫
 * @Expected result £∫
 */
public class orderPizza {

    @Test
    public void test() throws IOException {
        AbsFactory factory = new BJFactory();
        testAbsFactory(factory);
    }

    public void testAbsFactory(AbsFactory absFactory) throws IOException {
        Pizza pizza = null;
        String orderType = null;
        do {
            orderType = getType();
            pizza = absFactory.createPizza(orderType);
            if (pizza!=null) {
                pizza.toString();
            }else {
                System.out.println("null-----------");
            }
        } while (true);
    }


    private String getType() throws IOException {
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input pizza ÷÷¿‡:");
        String str = strin.readLine();
        return str;
    }
}
