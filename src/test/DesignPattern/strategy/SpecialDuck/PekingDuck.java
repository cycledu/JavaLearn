package DesignPattern.strategy.SpecialDuck;

import DesignPattern.strategy.Duck;
import DesignPattern.strategy.FlyBehavior;
import DesignPattern.strategy.QuackBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:07
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class PekingDuck extends Duck {
    public PekingDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }
}
