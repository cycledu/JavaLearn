package DesignPattern.factory.simplefactory.Pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/11:45
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class PepperPizza extends Pizza {

    public PepperPizza() {
        super("pepper");
    }

    @Override
    public void prepare() {
        System.out.println("��������");
    }
}
