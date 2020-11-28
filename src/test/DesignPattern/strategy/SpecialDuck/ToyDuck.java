package DesignPattern.strategy.SpecialDuck;

import DesignPattern.strategy.Duck;
import DesignPattern.strategy.FlyBehavior;
import DesignPattern.strategy.QuackBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:08
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class ToyDuck extends Duck {
    public ToyDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        super(flyBehavior, quackBehavior);
    }
}
