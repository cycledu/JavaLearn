package DesignPattern.strategy.FlyBehaviorImpl;

import DesignPattern.strategy.FlyBehavior;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/13:57
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public String flybehavior() {
        return "²»·É";
    }
}
