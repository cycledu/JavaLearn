package DesignPattern.factory.abstractfactory;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/13:18
 * @Description :³éÏó¹¤³§
 * @PageOrWebSite£º
 * @Expected result £º
 */
public interface AbsFactory {
    Pizza createPizza(String orderType);
}
