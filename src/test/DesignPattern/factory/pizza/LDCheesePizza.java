package DesignPattern.factory.pizza;

import DesignPattern.factory.Pizza;

/**
 * @Author : jingtao
 * @Data : 2020/11/16/12:16
 * @Description :
 * @PageOrWebSite��
 * @Expected result ��
 */
public class LDCheesePizza extends Pizza {
    public LDCheesePizza() {
        super("�׶�֥ʿ����");
    }

    @Override
    public void prepare() {
        System.out.println("�׶ص���������׼������");
    }
}
