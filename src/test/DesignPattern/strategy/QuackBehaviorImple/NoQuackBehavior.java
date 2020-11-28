package DesignPattern.strategy.QuackBehaviorImple;

import DesignPattern.strategy.QuackBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:00
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
public class NoQuackBehavior implements QuackBehavior {
    @Override
    public String QuaclBehavior() {
        return "����������";
    }
}
