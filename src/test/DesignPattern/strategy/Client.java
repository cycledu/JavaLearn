package DesignPattern.strategy;


import DesignPattern.strategy.FlyBehaviorImpl.FlyFactory;
import DesignPattern.strategy.QuackBehaviorImple.QuackFactory;
import DesignPattern.strategy.SpecialDuck.PekingDuck;
import DesignPattern.strategy.SpecialDuck.ToyDuck;
import DesignPattern.strategy.SpecialDuck.WildDuck;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : jingtao
 * @Data : 2020/08/15/14:08
 * @Description :
 * @Page or WebSite��
 * @Expected result ��
 */
public class Client {
    public static void main(String[] args) {

        List<Duck> ducks = new ArrayList<>();

        //Ӧ�����ഴ�������������Եĸ���
        ducks.add(new PekingDuck(FlyFactory.NoFlyBehavior(), QuackFactory.GaGaQuackBehavior()));
        ducks.add(new ToyDuck(FlyFactory.NoFlyBehavior(), QuackFactory.NoQuackBehavior()));
        ducks.add(new WildDuck());

        ducks.forEach(v -> {
            v.specialBehavior();
        });
    }
}
