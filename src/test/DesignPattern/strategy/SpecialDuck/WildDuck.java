package DesignPattern.strategy.SpecialDuck;

import DesignPattern.strategy.Duck;
import DesignPattern.strategy.FlyBehaviorImpl.GoodFlyBehavior;
import DesignPattern.strategy.QuackBehaviorImple.NoQuackBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:07
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class WildDuck extends Duck {
    public WildDuck() {
        super(new GoodFlyBehavior(), new NoQuackBehavior());
    }
}
