package DesignPattern.factory.pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:16
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class LDPepperPizza extends Pizza {
    public LDPepperPizza() {
        super("�׶غ�������");
    }

    @Override
    public void prepare() {
        System.out.println("�׶صĺ�������׼������");
    }
}
