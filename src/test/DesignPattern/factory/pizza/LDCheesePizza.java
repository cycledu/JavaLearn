package DesignPattern.factory.pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:16
 * @Description :
 * @PageOrWebSite£º
 * @Expected result £º
 */
public class LDCheesePizza extends Pizza {
    public LDCheesePizza() {
        super("Â×¶ØÖ¥Ê¿ÅûÈø");
    }

    @Override
    public void prepare() {
        System.out.println("Â×¶ØµÄÄÌÀÒÅûÈø×¼±¸²ÄÁÏ");
    }
}
