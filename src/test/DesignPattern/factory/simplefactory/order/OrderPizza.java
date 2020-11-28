package DesignPattern.factory.simplefactory.order;

import DesignPattern.factory.simplefactory.Pizza.CheesePizza;
import DesignPattern.factory.simplefactory.Pizza.GreekPizza;
import DesignPattern.factory.simplefactory.Pizza.PepperPizza;
import DesignPattern.factory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class OrderPizza {
    /**
     * ��ͳ�ķ�ʽ������������������ͱ����޸Ĵ���
     */
    public OrderPizza() {
        Pizza pizza = null;
        String orderType = null;
        do {
            orderType = getType();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
            } else if (orderType.equals("pepper")) {
                pizza = new PepperPizza();
            } else {
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);

    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza ����:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public OrderPizza(SimpleFactory simpleFactory) {
        setSimpleFactory(simpleFactory);
    }

    SimpleFactory simpleFactory;

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        String orderType = "";//�û�����
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            Pizza pizza = this.simpleFactory.creaetPizza(orderType);
            if (pizza != null) {
                pizza.toString();
            } else {
                System.out.println("����pizzaʧ��");
                break;
            }
        } while (true);
    }
}
