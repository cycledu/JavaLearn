package DesignPattern.factory.simplefactory.Pizza;

import DesignPattern.factory.Pizza;

public class GreekPizza extends Pizza {

    public GreekPizza() {
        super("greek");
    }

    @Override
    public void prepare() {
        System.out.println("Ï£À°ÅûÈø");
    }

}
