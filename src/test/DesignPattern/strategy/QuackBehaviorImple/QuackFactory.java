package DesignPattern.strategy.QuackBehaviorImple;

import DesignPattern.strategy.QuackBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:12
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class QuackFactory {
    public static QuackBehavior NoQuackBehavior() {
        return new NoQuackBehavior();
    }
    public static QuackBehavior GaGaQuackBehavior() {
        return new GaGaQuackBehavior();
    }
    public static QuackBehavior GeGeQuackBehavior() {
        return new GeGeGuackBehavior();
    }
}
