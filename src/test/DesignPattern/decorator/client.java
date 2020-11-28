package DesignPattern.decorator;

public class client {
    public static void main(String[] args) {
        Espresso espresso = new Espresso();
        milk milk = new milk(espresso);
        soy soy = new soy(milk);
        String des = soy.getDes();
        float cost = soy.cost();
        System.out.println(des+":"+"×Ü¼Û+"+cost);
    }
}
