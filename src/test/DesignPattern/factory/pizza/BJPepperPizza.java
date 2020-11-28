package DesignPattern.factory.pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:16
 * @Description :
 * @PageOrWebSite：
 * @Expected result ：
 */
public class BJPepperPizza extends Pizza {
    public BJPepperPizza() {
        super("北京胡椒披萨");
    }

    @Override
    public void prepare() {
        System.out.println("北京的胡椒披萨准备材料");
    }
}
