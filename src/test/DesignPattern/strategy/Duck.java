package DesignPattern.strategy;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/13:52
 * @Description :
 * @Page or WebSite£º
 * @Expected result £º
 */
public class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }
    public void specialBehavior() {
        String simpleName = this.getClass().getSimpleName();
        System.out.println(simpleName + "µÄÏ°ÐÔÊÇ£º" + flyBehavior.flybehavior() + "," + quackBehavior.QuaclBehavior());
    }
}
