package DesignPattern.strategy.FlyBehaviorImpl;

import DesignPattern.strategy.FlyBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:09
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class FlyFactory {
    public static FlyBehavior NoFlyBehavior() {
        return new NoFlyBehavior();
    }
    public static FlyBehavior GoodFlyBehavior() {
        return new GoodFlyBehavior();
    }
    public static FlyBehavior BadFlyBehavior() {
        return new BadFlyBehavior();
    }
}
