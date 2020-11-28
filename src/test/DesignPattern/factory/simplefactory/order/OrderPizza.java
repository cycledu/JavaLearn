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
     * 传统的方式，新增子类的数量，就必须修改代码
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
            System.out.println("input pizza 种类:");
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
        String orderType = "";//用户输入
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            Pizza pizza = this.simpleFactory.creaetPizza(orderType);
            if (pizza != null) {
                pizza.toString();
            } else {
                System.out.println("订购pizza失败");
                break;
            }
        } while (true);
    }
}
