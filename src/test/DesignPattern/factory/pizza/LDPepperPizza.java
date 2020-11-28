package DesignPattern.factory.pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:16
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class LDPepperPizza extends Pizza {
    public LDPepperPizza() {
        super("Â×¶Øºú½·ÅûÈø");
    }

    @Override
    public void prepare() {
        System.out.println("Â×¶ØµÄºú½·ÅûÈø×¼±¸²ÄÁÏ");
    }
}
