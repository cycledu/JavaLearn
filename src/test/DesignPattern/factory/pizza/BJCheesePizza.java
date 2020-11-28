package DesignPattern.factory.pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:16
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class BJCheesePizza extends Pizza {
    public BJCheesePizza() {
        super("bj cheese");
    }

    @Override
    public void prepare() {
        System.out.println("北京的奶酪披萨准备材料");
    }
}
